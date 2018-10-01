package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import com.capgemeini.serviciosya.dao.IProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("providers")
public class ProviderController {

    @Autowired
    private IProviderDao providerDao;

    public ProviderController(){

        super();
    }

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.providerDao.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id){

        ProviderEntity provider = this.providerDao.findOne(id);

        if (provider == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(this.providerDao.findOne(id));
        }
    }

    @RequestMapping(value = "/{findbydni}/{dni}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getDni(@PathVariable("dni") Integer dni){

        ProviderEntity provider = this.providerDao.findBydni(dni);

        if (provider == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(provider);
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {
            ProviderEntity provider = new ProviderEntity();
            provider.setId(id);
            provider.setName("name");

            this.providerDao.save(provider);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id) {
        if (providerDao.findOne(id) != null) {
            this.providerDao.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
