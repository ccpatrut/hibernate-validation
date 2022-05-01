package com.cpatrut.api.impl;

import com.cpatrut.api.ServiceApi;
import com.cpatrut.dto.ServiceTO;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class ServiceApiImpl implements ServiceApi {
    @Override
    public Uni<Response> save(ServiceTO service) {
        return null;
    }
}
