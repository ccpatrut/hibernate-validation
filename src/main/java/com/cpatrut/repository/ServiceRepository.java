package com.cpatrut.repository;

import com.cpatrut.dto.ServiceTO;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface ServiceRepository {
    Uni<UUID> save(final ServiceTO service);

    Uni<Boolean> isValid(final UUID businessId, final String name);
}
