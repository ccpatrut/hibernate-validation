package com.cpatrut.api.impl;

import com.cpatrut.api.ProductApi;
import com.cpatrut.dto.ServiceTO;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class ProductApiImpl implements ProductApi {
    @Override
    public Uni<Response> save(final ServiceTO service) {
        return null;
    }
}
