package com.cpatrut.service.impl;

import com.cpatrut.dto.ServiceTO;
import com.cpatrut.repository.ProductRepository;
import com.cpatrut.service.ProductService;
import io.smallrye.mutiny.Uni;

import java.util.Map;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Uni<UUID> save(final ServiceTO service) {
        //more  business logic
        return productRepository.save(service);
    }

    @Override
    public Uni<Boolean> isUniqueNameForBusinessId(final Map<String, String> fieldToValueMap) {
        //more  business logic
        return productRepository.isUniqueNameForBusinessId(fieldToValueMap);
    }
}
