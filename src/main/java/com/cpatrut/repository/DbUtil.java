package com.cpatrut.repository;

import com.google.common.base.CaseFormat;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowIterator;
import io.vertx.mutiny.sqlclient.RowSet;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

@UtilityClass
public class DbUtil {
    public static final String INSERT_INTO = "INSERT INTO ";

    public static boolean getBoolean(final RowSet<Row> row) {
        return row.iterator().hasNext() ? row.iterator().next().getBoolean("result") : row.iterator().hasNext();
    }

    public static String generateWhere(final Map<String, String> fieldToValueMap) {
        return IntStream.range(0, fieldToValueMap.size())
                .boxed()
                .collect(toMap(copyOf(fieldToValueMap.values())::get, Function.identity()))
                .entrySet()
                .stream()
                .map(s ->
                        String.format("%s = $%s", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s.getKey()), s.getValue() + 1)
                ).collect(joining(" and "));
    }

    public static UUID getId(final RowIterator<Row> row) {
        return row.next().getUUID("id");
    }
}
