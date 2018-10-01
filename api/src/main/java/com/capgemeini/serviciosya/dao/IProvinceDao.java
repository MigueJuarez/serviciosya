package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProvinceDao extends JpaRepository<ProvinceEntity,Integer> {

    List<ProvinceEntity> findBycountry_id(Integer country_id);
}
