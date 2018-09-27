package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository <CountryEntity,Integer> {

}
