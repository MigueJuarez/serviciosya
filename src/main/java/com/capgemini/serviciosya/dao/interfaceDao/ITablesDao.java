package com.capgemini.serviciosya.dao.interfaceDao;


import java.util.List;

public interface ITablesDao <o,s> {

    void create(o object);
    List<o> findAllOccupations ();
    void add (o object);
    void delete(o object);
    o searchById(s id);
    void update(s id, o object);
}
