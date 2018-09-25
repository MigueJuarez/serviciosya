package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity,Integer> {

    List<ProviderEntity> findAll();

    <S extends ProviderEntity> S saveAndFlush(S s);

    ProviderEntity getOne(Integer integer);

    <S extends ProviderEntity> S save(S s);

    long count();

    void delete(Integer integer);

    void delete(ProviderEntity providerEntity);

    void deleteAll();
}
