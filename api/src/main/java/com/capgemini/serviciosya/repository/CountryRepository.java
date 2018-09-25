package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository <CountryEntity,Integer> {

    public CountryEntity save(CountryEntity country);
    public void delete(CountryEntity country);
    public void delete(Integer id);
    public CountryEntity getOne(Integer id);
    public CountryEntity getOne(CountryEntity country);
    public void upgrade(CountryEntity country);
    public List<CountryEntity> findAll();
    public long count();
}
