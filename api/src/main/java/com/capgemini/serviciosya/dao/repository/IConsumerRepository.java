package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConsumerRepository extends JpaRepository<ConsumerEntity,Integer> {

    public void add(ConsumerEntity consumer);
    public void delete(ConsumerEntity consumer);
    public List<ConsumerEntity> findAll();
    public ConsumerEntity findById(Integer id);
    void upgrade(ConsumerEntity consumer);
}
