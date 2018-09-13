package com.capgemini.serviciosya.dao.jdbcDao;

import com.capgemini.serviciosya.beans.domain.entity.CityEntity;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;

import java.util.List;

public class CityJdbcDao implements ITablesDao<CityEntity,String> {


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
