package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity,Integer> {

    public void add(CityEntity city);
    public void delete(CityEntity city);
    public List<CityEntity> findAll();
    public CityEntity searchById(Integer id);
    void upgrade(CityEntity city);
}
