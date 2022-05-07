package com.cpatrut.service;

import com.cpatrut.dto.ProductTO;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public interface ProductService {
    Uni<UUID> save(final ProductTO service);

}
