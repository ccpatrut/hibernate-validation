package com.cpatrut.dto;

import com.cpatrut.dto.validation.uniqby.UniqBy;
import com.cpatrut.service.impl.UniqProductPerBusiness;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Value;

import java.util.UUID;

@Value
@RegisterForReflection
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@UniqBy(fields = {"businessId", "name"}, strategyToValidate = UniqProductPerBusiness.class)
public class ProductTO {
    UUID id;
    String name;
    UUID businessId;
}
