package com.capgemini.serviciosya.dao;


import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;

import java.util.List;

public interface IDao<o,s> {

    void create(o object);
    void add (o object);
    void delete(o object);
    o searchById(s id);
    List<o> findAll();
    o findById(int id);
    void update(ProvinceEntity p);
}
