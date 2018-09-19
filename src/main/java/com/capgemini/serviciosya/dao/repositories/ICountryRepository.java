package com.capgemini.serviciosya.dao.repositories;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountryRepository extends JpaRepository<CountryEntity,Integer> {

    CountryEntity findOneByCode (String code);

    List<CountryEntity> findAllByIdBetween (Integer start, Integer end);

    List<CountryEntity> findAllByIdGreaterThan (Integer value);

    //@Query("FROM Country c WHERE c.id < :id")
    //List<CountryEntity> findAllByIdIsLessThan2 (@Param("id") Integer id);

    @Query (value = "SELECT * FROM country WHERE cou_name LIKE ?1",
            nativeQuery = true)
    List<CountryEntity> findAllByName (String val);

}
