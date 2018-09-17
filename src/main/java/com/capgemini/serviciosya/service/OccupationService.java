package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.domain.OccupationEntity;
import com.capgemini.serviciosya.dao.IDao;

import java.util.List;

public class OccupationService {

    private IDao occupationDao;


    public OccupationService () {

        super ();
    }

    public OccupationService (IDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IDao occupationDao) {

        this.occupationDao = occupationDao;
    }

    public List<OccupationEntity> findAllOccupations () {

        return this.occupationDao.findAll ();
    }

    public void addOccupation (OccupationEntity occupationEntity) {

        this.occupationDao.create (occupationEntity);
    }

    public void deleteOccupation(OccupationEntity occupationEntity){

        this.occupationDao.delete(occupationEntity);
    }

    public void searchByIdOccupation(String id){

        this.occupationDao.searchById(id);
    }
}
