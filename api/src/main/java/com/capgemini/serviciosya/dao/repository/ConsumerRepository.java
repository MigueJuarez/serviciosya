package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepository extends JpaRepository <ConsumerEntity,Integer> {

    public List<ConsumerEntity> findAll();

    public ConsumerEntity saveAndFlush(ConsumerEntity s);

    ConsumerEntity getOne(Integer integer);

    public ConsumerEntity save(ConsumerEntity s);

    public long count();

    public void delete(Integer integer);

    public void delete(ConsumerEntity consumerEntity);

    public void deleteAll();
}
