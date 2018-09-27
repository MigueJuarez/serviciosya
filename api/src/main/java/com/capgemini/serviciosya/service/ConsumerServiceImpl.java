package com.capgemini.serviciosya.service;

import com.capgemini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemini.serviciosya.dao.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Override
    public void createConsumer(ConsumerEntity consumer) {
        consumerRepository.save(consumer);
    }

    @Override
    public void deleteConsumer(ConsumerEntity consumer) {
        consumerRepository.delete(consumer);
    }

    @Override
    public List<ConsumerEntity> findAllConsumers() {
        return consumerRepository.findAll();
    }

    @Override
    public ConsumerEntity getConsumer(Integer id) {
        return consumerRepository.getOne(id);
    }
}
