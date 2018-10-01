package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.CityEntity;
import com.capgemeini.serviciosya.dao.ICityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private ICityDao cityDao;

    CityController(){

        super();
    }

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.cityDao.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id){

        CityEntity city = this.cityDao.findOne(id);

        if (city == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(this.cityDao.findOne(id));
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {
            CityEntity city = new CityEntity();
            city.setId(id);
            city.setName("name");

            this.cityDao.save(city);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        if (cityDao.findOne(id) != null) {
            this.cityDao.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
