package com.cpatrut.repository.impl;

import com.cpatrut.dto.ServiceTO;
import com.cpatrut.repository.ServiceRepository;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public class ServiceRepositoryImpl implements ServiceRepository {


    @Override
    public Uni<UUID> save(final ServiceTO service) {
        return null;
    }

    @Override
    public Uni<Boolean> isValid(final UUID businessId, final String name) {
        return null;
    }
}
