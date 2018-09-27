package com.capgemini.serviciosya.dao.repository;

import com.capgemini.serviciosya.beans.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Integer> {

    public List<ServiceEntity> findAll();
    public <S extends ServiceEntity> List<S> save(Iterable<S> iterable);
    public ServiceEntity getOne(Integer integer);
    public long count();
    public void delete(Integer integer);
    public void delete(ServiceEntity serviceEntity);
}
