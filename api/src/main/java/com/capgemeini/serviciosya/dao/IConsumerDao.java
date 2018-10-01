package com.capgemeini.serviciosya.dao;

import com.capgemeini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsumerDao extends JpaRepository <ConsumerEntity,Integer> {
}
