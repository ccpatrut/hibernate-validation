package com.cpatrut.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
@RegisterForReflection
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BusinessTO {
    @Null
    UUID id;
    
    @NotNull
    @Size(min = 5, max = 20)
    String name;

    @NotNull
    String description;
    @NotNull
    @Size(min = 5, max = 100)
    String cta;

    @Builder
    BusinessTO(final UUID id, final String name, final String description, final String cta) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cta = cta;
    }
}
