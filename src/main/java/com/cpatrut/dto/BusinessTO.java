package com.cpatrut.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@RegisterForReflection
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BusinessTO {
    UUID id;
    String name;
    String description;
    String cta;

    @Builder
    BusinessTO(final UUID id, final String name, final String description, final String cta) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cta = cta;
    }
}
