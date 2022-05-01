package com.cpatrut.api.impl;

import com.cpatrut.api.BusinessApi;
import com.cpatrut.dto.BusinessTO;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.core.Response;

public class BusinessApiImpl implements BusinessApi {
    @Override
    public Uni<Response> save(BusinessTO businessSave) {
        return null;
        
    }
}
