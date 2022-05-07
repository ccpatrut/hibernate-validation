package com.cpatrut.dto.validation.uniqby;

import io.smallrye.mutiny.Uni;

import java.util.Map;

public interface UniquenessValidationExecutor {
    Uni<Boolean> isUnique(Map<String, String> fieldToValueMap);
}
