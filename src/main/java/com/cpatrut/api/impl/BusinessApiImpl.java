package com.cpatrut.api.impl;

import com.cpatrut.api.BusinessApi;
import com.cpatrut.dto.BusinessTO;
import com.cpatrut.service.BusinessService;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class BusinessApiImpl implements BusinessApi {
    private final BusinessService businessService;

    public BusinessApiImpl(final BusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public Uni<Response> save(final BusinessTO businessSave) {
        return businessService.save(businessSave)
                .onItem().transform(uuid -> Response.ok(uuid).build());

    }
}
