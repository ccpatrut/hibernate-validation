package com.cpatrut.api.impl;

import com.cpatrut.api.ProductApi;
import com.cpatrut.dto.ProductTO;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class ProductApiImpl implements ProductApi {
    @Override
    public Uni<Response> save(final ProductTO service) {
        return null;
    }
}
