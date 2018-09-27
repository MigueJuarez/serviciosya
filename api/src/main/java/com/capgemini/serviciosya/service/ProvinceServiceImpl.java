package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public ProvinceEntity createProvince(ProvinceEntity province) {
        return provinceRepository.save(province);
    }

    @Override
    public ProvinceEntity getProvince(ProvinceEntity province) {
        return provinceRepository.getOne(province.getId());
    }

    @Override
    public ProvinceEntity upgradeProvince(ProvinceEntity province) {
        return provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(ProvinceEntity province) {
        provinceRepository.delete(province);
    }

    @Override
    public List<ProvinceEntity> findAllProvinces() {
        return provinceRepository.findAll();
    }
}
