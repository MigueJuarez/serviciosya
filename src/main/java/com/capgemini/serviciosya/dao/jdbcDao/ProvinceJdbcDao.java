package com.capgemini.serviciosya.dao.jdbcDao;

import com.capgemini.serviciosya.beans.domain.Province;
import com.capgemini.serviciosya.beans.domain.entity.ProvinceEntity;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;

import java.util.List;

public class ProvinceJdbcDao implements ITablesDao<ProvinceEntity,String> {


    @Override
    public void create(ProvinceEntity object) {

    }

    @Override
    public List<ProvinceEntity> findAllOccupations() {
        return null;
    }

    @Override
    public void add(ProvinceEntity object) {

    }

    @Override
    public void delete(ProvinceEntity object) {

    }

    @Override
    public ProvinceEntity searchById(String id) {
        return null;
    }

    @Override
    public void update(String id, ProvinceEntity object) {

    }
}
