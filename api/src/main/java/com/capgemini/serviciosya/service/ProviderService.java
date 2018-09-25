package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;

import java.util.List;

public interface ProviderService {

    public void createProvider(ProviderEntity provider);
    public void deleteProvider(ProviderEntity provider);
    public List<ProviderEntity> findAllProviders();
    public void upgradeProvider(ProviderEntity provider);
    public ProviderEntity getProvider(ProviderEntity provider);
}
