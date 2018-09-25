package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;

import java.util.List;

public interface ConsumerService {

    public void createConsumer(ConsumerEntity consumer);
    public void deleteConsumer(ConsumerEntity consumer);
    public List<ConsumerEntity> findAllConsumers();
    public ConsumerEntity getConsumer(Integer id);
}
