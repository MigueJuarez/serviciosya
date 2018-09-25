package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ServiceEntity;
import com.capgemini.serviciosya.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void createService(ServiceEntity service) {
        serviceRepository.save(service);
    }

    @Override
    public void upgradeService(ServiceEntity service) {
        serviceRepository.save(service);
    }

    @Override
    public ServiceEntity getService(ServiceEntity service) {
        return serviceRepository.getOne(service.getId());
    }

    @Override
    public void deleteService(ServiceEntity service) {
        serviceRepository.delete(service);
    }
}
