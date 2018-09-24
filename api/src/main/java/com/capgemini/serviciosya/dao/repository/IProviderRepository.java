package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProviderRepository extends JpaRepository<ProviderEntity,Integer> {

    public void add(ProviderEntity provider);
    public void delete(ProviderEntity provider);
    public List<ProviderEntity> findAll();
    public ProviderEntity searchById(Integer id);
    void upgrade(ProviderEntity provider);
    void save(List<ProviderEntity> providers);
}
