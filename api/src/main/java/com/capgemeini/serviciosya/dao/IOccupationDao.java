package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOccupationDao extends JpaRepository <OccupationEntity,Integer> {

}
