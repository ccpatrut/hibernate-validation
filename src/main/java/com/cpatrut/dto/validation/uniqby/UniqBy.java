package com.cpatrut.dto.validation.uniqby;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = UniquePerObjectValidator.class)
public @interface UniqBy {
    String message() default "Already one element for this entity defined";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<? extends UniquenessValidationExecutor> strategyToValidate();

    String[] fields();


}
