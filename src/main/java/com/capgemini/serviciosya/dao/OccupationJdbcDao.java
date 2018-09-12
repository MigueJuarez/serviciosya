package com.capgemini.serviciosya.dao;

import com.capgemini.serviciosya.beans.domain.Occupation;

import java.util.List;

public class OccupationJdbcDao implements IOccupationDao {

    @Override
    public List<Occupation> findAllOccupations() {
        return null;
    }

    @Override
    public void add(Occupation occupation) {

    }

    @Override
    public void delete(Occupation occupation) {

    }

    @Override
    public Occupation searchById(String id) {
        return null;
    }

    @Override
    public void update(String id, Occupation occupation) {

    }
}
