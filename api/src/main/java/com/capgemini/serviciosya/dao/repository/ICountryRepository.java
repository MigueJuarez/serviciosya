package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity,Integer> {

    public void add(CountryEntity country);
    public void delete(CountryEntity country);
    public List<CountryEntity> findAll();
    public CountryEntity searchById(Integer id);
    void upgrade(CountryEntity country);

    @Query(value = "SELECT * FROM country WHERE name LIKE ?1", nativeQuery = true)
    List<CountryEntity> findAllByName (String val);
}

