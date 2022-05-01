package com.cpatrut.repository.impl;

import com.cpatrut.dto.BusinessTO;
import com.cpatrut.repository.BusinessRepository;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public class BusinessRepositoryImpl implements BusinessRepository {
    @Override
    public Uni<UUID> save(final BusinessTO business) {
        return null;
    }
}
