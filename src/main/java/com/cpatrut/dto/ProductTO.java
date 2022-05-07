package com.cpatrut.dto;

import com.cpatrut.dto.validation.uniqby.UniqBy;
import com.cpatrut.service.impl.UniqProductPerBusiness;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
@RegisterForReflection
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@UniqBy(fields = {"businessId", "name"}, strategyToValidate = UniqProductPerBusiness.class)
public class ProductTO {
    @Null
    UUID id;

    @NotNull
    @Size(min = 3, max = 100)
    String name;
    @NotNull
    UUID businessId;
}
