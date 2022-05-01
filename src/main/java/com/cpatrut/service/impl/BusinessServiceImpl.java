package com.cpatrut.service.impl;

import com.cpatrut.dto.BusinessTO;
import com.cpatrut.repository.BusinessRepository;
import com.cpatrut.service.BusinessService;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    BusinessServiceImpl(final BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public Uni<UUID> save(final BusinessTO business) {
        return businessRepository.save(business);
    }
}
