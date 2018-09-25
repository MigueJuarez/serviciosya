package com.capgemini.serviciosya.repository;

import com.capgemini.serviciosya.beans.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository <ProvinceEntity,Integer> {

    public void delete(ProvinceEntity province);
    public ProvinceEntity getOne(Integer id);
    public List<ProvinceEntity> findAll();
    ProvinceEntity save(ProvinceEntity province);
}
