package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.domain.Occupation;
import com.capgemini.serviciosya.dao.IOccupationDao;

import java.util.List;

public class OccupationService {

    private IOccupationDao occupationDao;

    public OccupationService () {

        super ();
    }

    public OccupationService (IOccupationDao occupationDao) {

        super ();

        this.occupationDao = occupationDao;
    }

    public void setOccupationDao(IOccupationDao occupationDao) {

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

    public Occupation searchByIdOccupation(String id){

        return this.occupationDao.searchById(id);
    }
    public  void upgradeOccupation(String id, Occupation occupation){
        this.occupationDao.update(id,occupation);
    }
}
