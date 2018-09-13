package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.interfaceDao.ITablesDao;

import java.util.List;

public class OccupationService {

    private ITablesDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (ITablesDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(ITablesDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<Occupation> findAllOccupations () {

        return this.occupationDao.findAllOccupations ();
    }

    public void addOccupation (Occupation occupation) {

        this.occupationDao.add (occupation);
    }

    public void deleteOccupation(Occupation occupation){

        this.occupationDao.delete(occupation);
    }

    public void searchByIdOccupation(String id){

        this.occupationDao.searchById(id);
    }
}
