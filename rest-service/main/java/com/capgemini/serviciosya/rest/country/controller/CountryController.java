package com.capgemini.serviciosya.rest.country.controller;

import com.capgemini.serviciosya.rest.country.entity.Country;
import com.capgemini.serviciosya.rest.country.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping ("country")
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(){
        super();
    }

    @Autowired
    public void serProductRepository(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @RequestMapping (method = RequestMethod.GET,produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.countryRepository.findAll());
    }

    @RequestMapping (value = "/id",method = RequestMethod.GET,produces = (MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<?> get (@PathVariable ("id") Integer id){

        Country country = this.countryRepository.findOne(id);

        if(country == null){
            return ResponseEntity.notFound().build();
        }
        else
            return ResponseEntity.ok(country);
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {
            Country country = new Country();
            country.setId(id);
            country.setName("name");

            this.countryRepository.save(country);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        this.countryRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
