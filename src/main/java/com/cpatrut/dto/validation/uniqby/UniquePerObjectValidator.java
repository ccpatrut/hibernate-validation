package com.cpatrut.dto.validation.uniqby;

import com.google.common.collect.Maps;
import io.quarkus.arc.All;
import io.quarkus.arc.InstanceHandle;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@Slf4j
public class UniquePerObjectValidator implements ConstraintValidator<UniqBy, Object> {

    private final List<InstanceHandle<UniquenessValidationExecutor>> validators;

    private Class<? extends UniquenessValidationExecutor> uniqnessExecutor;
    private String[] uniquenessFields;


    UniquePerObjectValidator(@All final List<InstanceHandle<UniquenessValidationExecutor>> validators) {
        this.validators = validators;
    }

    @Override
    public void initialize(final UniqBy constraintAnnotation) {
        uniqnessExecutor = constraintAnnotation.strategyToValidate();
        uniquenessFields = constraintAnnotation.fields();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        final Map<Optional<String>, String> fieldToValueMap = Maps.uniqueIndex(Arrays.asList(uniquenessFields), field ->
                tryGetProperty(value, field));

        final List<Optional<String>> collect = fieldToValueMap.keySet().stream()
                .filter(Optional::isEmpty)
                .collect(Collectors.toList());

        if (collect.size() != 0) {
            return false;
        }

        return validators.stream()
                .filter(handle -> handle.getBean().getBeanClass().getName().equals(uniqnessExecutor.getName()))
                .findFirst()
                .orElseThrow(ValidationException::new)
                .get()
                .isUnique(
                        fieldToValueMap.entrySet().stream().collect(Collectors.toMap(optionalKey -> optionalKey.getKey().get(), Map.Entry::getValue))
                )
                .await()
                .atMost(Duration.of(2, ChronoUnit.SECONDS));
    }

    private Optional<String> tryGetProperty(final Object object, final String property) {
        try {
            final String fieldValue = BeanUtils.getProperty(object, property);
            return fieldValue == null ? Optional.empty() : of(fieldValue);
        } catch (final IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("Invalid object: {} ", e);
        }
        return empty();
    }
}
