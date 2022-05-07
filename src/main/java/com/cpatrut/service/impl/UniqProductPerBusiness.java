package com.cpatrut.service.impl;

import com.cpatrut.dto.validation.uniqby.UniquenessValidationExecutor;
import com.cpatrut.repository.ProductRepository;
import io.smallrye.mutiny.Uni;

import java.util.Map;

public class UniqProductPerBusiness implements UniquenessValidationExecutor {
    private final ProductRepository productRepository;

    UniqProductPerBusiness(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Uni<Boolean> isUnique(final Map<String, String> fieldToValueMap) {
        return productRepository.isUniqueNameForBusinessId(fieldToValueMap);
    }
}
