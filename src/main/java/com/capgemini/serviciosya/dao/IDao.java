package com.capgemini.serviciosya.dao;


import java.util.List;

public interface IDao<o,s> {

    void create(o object);
    void delete(o object);
    o searchById(s id);
    List<o> findAll();
    void update(o object);
}
