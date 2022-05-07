package com.cpatrut.repository.impl;

import com.cpatrut.dto.ProductTO;
import com.cpatrut.repository.DbUtil;
import com.cpatrut.repository.ProductRepository;
import com.google.common.collect.Lists;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static com.cpatrut.repository.DbUtil.*;
import static java.util.List.copyOf;

@ApplicationScoped
public class ProductRepositoryImpl implements ProductRepository {
    private final PgPool pgPool;

    ProductRepositoryImpl(final PgPool pgPool) {
        this.pgPool = pgPool;
    }

    @Override
    public Uni<UUID> save(final ProductTO product) {
        return pgPool.withTransaction(con -> con.preparedQuery(INSERT_INTO +
                        ProductRepository.TABLE +
                        " (id, name,business_id, creation_time)" +
                        " VALUES ($1, $2, $3, $4) RETURNING id")
                .execute(Tuple.tuple(
                        Lists.newArrayList(UUID.randomUUID(),
                                product.getName(), product.getBusinessId(), LocalDateTime.now())
                ))
                .onItem().transform(row -> getId(row.iterator())));
    }

    @Override
    public Uni<Boolean> isUniqueNameForBusinessId(final Map<String, String> fieldToValueMap) {
        final String whereClause = generateWhere(fieldToValueMap);
        return pgPool.withTransaction(
                sqlConnection -> sqlConnection.preparedQuery("SELECT true as result from " + ProductRepository.TABLE
                                + " where " + whereClause + " LIMIT 1; ")
                        .execute(Tuple.tuple(copyOf(fieldToValueMap.keySet())))
                        .onItem().transform(result -> !DbUtil.getBoolean(result)));
    }


}
