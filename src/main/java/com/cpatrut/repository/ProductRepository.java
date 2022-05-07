package com.cpatrut.repository;

import com.cpatrut.dto.ProductTO;
import io.smallrye.mutiny.Uni;

import java.util.Map;
import java.util.UUID;

public interface ProductRepository {
    String TABLE = "data.product";

    Uni<UUID> save(final ProductTO service);

    Uni<Boolean> isUniqueNameForBusinessId(final Map<String, String> fieldToValueMap);
}
