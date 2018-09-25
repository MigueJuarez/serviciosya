package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ServiceEntity;

public interface ServiceService {

    public void createService(ServiceEntity service);
    public void upgradeService(ServiceEntity service);
    public ServiceEntity getService(ServiceEntity service);
    public void deleteService(ServiceEntity service);
}
