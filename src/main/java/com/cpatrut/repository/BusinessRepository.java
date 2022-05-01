package com.cpatrut.repository;

import com.cpatrut.dto.BusinessTO;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface BusinessRepository {
    Uni<UUID> save(final BusinessTO business);
}
