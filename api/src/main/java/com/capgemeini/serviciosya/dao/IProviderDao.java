package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderDao extends JpaRepository <ProviderEntity,Integer> {

    ProviderEntity findBydni(Integer dni);
}
