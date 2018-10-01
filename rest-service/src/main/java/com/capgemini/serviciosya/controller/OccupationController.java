package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.OccupationEntity;
import com.capgemeini.serviciosya.beans.entity.ProviderEntity;
import com.capgemeini.serviciosya.dao.IOccupationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("occupations")
public class OccupationController {

    @Autowired
    private IOccupationDao occupationDao;

    public OccupationController(){

        super();
    }

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.occupationDao.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id){

        OccupationEntity province = this.occupationDao.findOne(id);

        if (province == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(this.occupationDao.findOne(id));
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {

            OccupationEntity occupation = new OccupationEntity();
            Set <ProviderEntity> providers = new HashSet<>();
            ProviderEntity provider = new ProviderEntity(1,"name");
            providers.add(provider);

            occupation.setId(id);
            occupation.setName("name");
            occupation.setProviders(providers);

            this.occupationDao.save(occupation);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        this.occupationDao.delete(id);
        return ResponseEntity.noContent().build();
    }
}
