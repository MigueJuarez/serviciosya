package com.capgemini.serviciosya.dao;


import com.capgemini.serviciosya.beans.domain.Occupation;

import java.util.List;

public interface IOccupationDao {

    List<Occupation> findAllOccupations ();
    void add (Occupation occupation);
    void delete(Occupation occupation);
    Occupation searchById(String id);
}
