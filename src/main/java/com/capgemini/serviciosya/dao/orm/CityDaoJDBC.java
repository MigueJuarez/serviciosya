package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.IDao;

import java.util.List;

public class CityDaoJDBC implements IDao <CityEntity,Integer> {


    @Override
    public void create(CityEntity object) {

    }

    @Override
    public void add(CityEntity object) {

    }

    @Override
    public void delete(CityEntity object) {

    }

    @Override
    public CityEntity searchById(Integer id) {
        return null;
    }

    @Override
    public List<CityEntity> findAll() {
        return null;
    }

    @Override
    public CityEntity findById(int id) {
        return null;
    }

    @Override
    public void update(ProvinceEntity p) {

    }
}
