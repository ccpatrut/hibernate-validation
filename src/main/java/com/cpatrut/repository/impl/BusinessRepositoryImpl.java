package com.cpatrut.repository.impl;

import com.cpatrut.dto.BusinessTO;
import com.cpatrut.repository.BusinessRepository;
import com.google.common.collect.Lists;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.cpatrut.repository.DbUtil.INSERT_INTO;
import static com.cpatrut.repository.DbUtil.getId;

@ApplicationScoped
public class BusinessRepositoryImpl implements BusinessRepository {

    private final PgPool pgPool;

    BusinessRepositoryImpl(final PgPool pgPool) {
        this.pgPool = pgPool;
    }

    @Override
    public Uni<UUID> save(final BusinessTO business) {
        return pgPool.withTransaction(con -> con.preparedQuery(INSERT_INTO +
                        BusinessRepository.TABLE +
                        " (id, name, description, cta, creation_time) VALUES (" +
                        "$1, $2, $3, $4,  $5) RETURNING id")
                .execute(Tuple.tuple(
                        Lists.newArrayList(UUID.randomUUID(),
                                business.getName(),
                                business.getDescription(),
                                business.getCta(),
                                LocalDateTime.now())
                ))
                .onItem().transform(row -> getId(row.iterator())));
    }
}
