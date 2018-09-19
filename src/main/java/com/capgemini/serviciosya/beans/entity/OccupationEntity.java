package com.capgemini.serviciosya.beans.entity;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;

import java.util.List;

public class OccupationEntity implements IOccupationDao {

    @Override
    public void create(Occupation object) {

    }

    @Override
    public void delete(Occupation object) {

    }

    @Override
    public Occupation searchById(Integer id) {
        return null;
    }

    @Override
    public List<Occupation> findAll() {
        return null;
    }

    @Override
    public void update(Occupation object) {

    }
}
