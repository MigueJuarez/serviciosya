package com.capgemini.serviciosya.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.serviciosya.beans.entity.ProvinceEntity;

import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {

    public void add(ProvinceEntity province);
    public void delete(ProvinceEntity province);
    public List<ProvinceEntity> findAll();
    public ProvinceEntity searchById(Integer id);
    void upgrade(ProvinceEntity province);
}
