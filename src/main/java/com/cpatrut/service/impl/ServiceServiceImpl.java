package com.cpatrut.service.impl;

import com.cpatrut.dto.ServiceTO;
import com.cpatrut.repository.ServiceRepository;
import com.cpatrut.service.ServiceService;
import io.smallrye.mutiny.Uni;

import java.util.UUID;

public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Uni<UUID> save(final ServiceTO service) {
        //more  business logic
        return serviceRepository.save(service);
    }

    @Override
    public Uni<Boolean> isValid(final UUID businessId, final String name) {
        //more  business logic
        return serviceRepository.isValid(businessId, name);
    }
}
