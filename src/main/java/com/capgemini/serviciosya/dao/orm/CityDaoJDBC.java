package com.capgemini.serviciosya.dao.orm;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import com.capgemini.serviciosya.dao.IDao;

import java.util.List;

public class CityDaoJDBC implements IDao <CityEntity,String> {


    @Override
    public void create(CityEntity object) {

    }

    @Override
    public List<CityEntity> findAllOccupations() {
        return null;
    }

    @Override
    public void add(CityEntity object) {

    }

    @Override
    public void delete(CityEntity object) {

    }

    @Override
    public CityEntity searchById(String id) {
        return null;
    }

    @Override
    public void update(String id, CityEntity object) {

    }
}
