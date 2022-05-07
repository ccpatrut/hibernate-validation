package com.cpatrut.service.impl;

import com.cpatrut.dto.ProductTO;
import com.cpatrut.repository.ProductRepository;
import com.cpatrut.service.ProductService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Uni<UUID> save(final ProductTO service) {
        return productRepository.save(service);
    }
}
