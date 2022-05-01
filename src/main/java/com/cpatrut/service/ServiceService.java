package com.cpatrut.service;

import com.cpatrut.dto.ServiceTO;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface ServiceService {
    Uni<UUID> save(final ServiceTO service);

    Uni<Boolean> isUniqueNameForBusinessId(final UUID businessId, final String name);
}
