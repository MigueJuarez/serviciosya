package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProviderDao extends JpaRepository <ProviderEntity,Integer> {

}
