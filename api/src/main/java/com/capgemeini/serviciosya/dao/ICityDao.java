package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDao extends JpaRepository<CityEntity,Integer> {

}
