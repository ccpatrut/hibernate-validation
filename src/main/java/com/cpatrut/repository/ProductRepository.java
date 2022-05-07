package com.cpatrut.repository;

import com.cpatrut.dto.ServiceTO;
import io.smallrye.mutiny.Uni;

import java.util.Map;
import java.util.UUID;

public interface ProductRepository {
    String TABLE = "data.product";

    Uni<UUID> save(final ServiceTO service);

    Uni<Boolean> isUniqueNameForBusinessId(final Map<String, String> fieldToValueMap);
}
