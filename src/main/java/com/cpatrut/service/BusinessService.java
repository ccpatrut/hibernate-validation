package com.cpatrut.service;

import com.cpatrut.dto.BusinessTO;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface BusinessService {
    Uni<UUID> save(final BusinessTO business);
}
