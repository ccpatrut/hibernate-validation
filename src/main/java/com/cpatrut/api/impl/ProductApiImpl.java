package com.cpatrut.api.impl;

import com.cpatrut.api.ProductApi;
import com.cpatrut.dto.ProductTO;
import com.cpatrut.service.ProductService;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class ProductApiImpl implements ProductApi {
    private final ProductService productService;

    ProductApiImpl(final ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Uni<Response> save(final ProductTO service) {
        return productService.save(service)
                .onItem().transform(uuid -> Response.ok(uuid).build());
    }
}
