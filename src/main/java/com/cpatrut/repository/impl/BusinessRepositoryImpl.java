package com.cpatrut.repository.impl;

import com.cpatrut.dto.BusinessTO;
import com.cpatrut.repository.BusinessRepository;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BusinessRepositoryImpl implements BusinessRepository {
    private final PgPool pgPool;

    BusinessRepositoryImpl(final PgPool pgPool) {
        this.pgPool = pgPool;
    }

    @Override
    public Uni<UUID> save(final BusinessTO business) {
        return null;
    }
}
