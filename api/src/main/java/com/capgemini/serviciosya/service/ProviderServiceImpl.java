package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import com.capgemini.serviciosya.dao.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public void createProvider(ProviderEntity provider) {
        providerRepository.save(provider);
    }

    @Override
    public void deleteProvider(ProviderEntity provider) {
        providerRepository.delete(provider);
    }

    @Override
    public List<ProviderEntity> findAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public void upgradeProvider(ProviderEntity provider) {
        providerRepository.saveAndFlush(provider);
    }

    @Override
    public ProviderEntity getProvider(ProviderEntity provider) {
        return providerRepository.getOne(provider.getId());
    }
}
