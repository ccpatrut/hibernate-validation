package com.cpatrut.repository.impl;

import com.cpatrut.dto.ServiceTO;
import com.cpatrut.repository.BusinessRepository;
import com.cpatrut.repository.ServiceRepository;
import com.google.common.collect.Lists;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.cpatrut.repository.DbUtil.INSERT_INTO;
import static com.cpatrut.repository.DbUtil.getId;

public class ServiceRepositoryImpl implements ServiceRepository {
    private final PgPool pgPool;

    ServiceRepositoryImpl(final PgPool pgPool) {
        this.pgPool = pgPool;
    }

    @Override
    public Uni<UUID> save(final ServiceTO business) {
        return pgPool.withTransaction(con -> con.preparedQuery(INSERT_INTO + BusinessRepository.TABLE +
                        " (id, name, description, cta, creation_time) VALUES ($1, $2, $3, $4,  $5, $6, $7, $8) RETURNING id")
                .execute(Tuple.tuple(
                        Lists.newArrayList(UUID.randomUUID(), business.getName(), LocalDateTime.now())
                ))
                .onItem().transform(row -> getId(row.iterator())));
    }

    @Override
    public Uni<Boolean> isUniqueNameForBusinessId(final UUID businessId, final String name) {
        return null;
    }


}
