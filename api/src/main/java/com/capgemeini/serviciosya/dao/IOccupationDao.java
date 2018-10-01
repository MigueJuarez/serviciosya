package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOccupationDao extends JpaRepository <OccupationEntity,Integer> {

}
