package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.ConsumerEntity;
import com.capgemeini.serviciosya.dao.IConsumerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("consumers")
public class ConsumerController {

    @Autowired
    private IConsumerDao consumerDao;

    public ConsumerController(){

        super();
    }

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.consumerDao.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id){

        ConsumerEntity consumer = this.consumerDao.findOne(id);

        if (consumer == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(consumer);
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {
            ConsumerEntity consumer = new ConsumerEntity();
            consumer.setId(id);
            consumer.setName("name");
            consumer.setLastName("lastName");
            this.consumerDao.save(consumer);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        if (consumerDao.findOne(id) != null) {
            this.consumerDao.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
