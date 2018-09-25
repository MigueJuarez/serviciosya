package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;

import java.util.List;

public interface ProvinceService {

    ProvinceEntity createProvince(ProvinceEntity province);
    ProvinceEntity getProvince(ProvinceEntity province);
    ProvinceEntity upgradeProvince(ProvinceEntity province);
    void deleteProvince (ProvinceEntity province);
    List<ProvinceEntity> findAllProvinces();
}
