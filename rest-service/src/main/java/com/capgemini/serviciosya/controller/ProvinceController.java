package com.capgemini.serviciosya.controller;

import com.capgemeini.serviciosya.beans.entity.ProvinceEntity;
import com.capgemeini.serviciosya.dao.IProvinceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("provinces")
public class ProvinceController {

    @Autowired
    private IProvinceDao provinceDao;

    public ProvinceController(){

        super();
    }

    @RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(){
        return ResponseEntity.ok(this.provinceDao.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(@PathVariable("id") Integer id){

        ProvinceEntity province = this.provinceDao.findOne(id);

        if (province == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(this.provinceDao.findOne(id));
        }
    }

    @RequestMapping(value = "/{findbycountry}/{country_id}", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getbycountry(@PathVariable("country_id") Integer country_id){

        List <ProvinceEntity> provinces = this.provinceDao.findBycountry_id(country_id);

        if (provinces.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(provinces);
        }
    }

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Map<Integer,Object> data, @PathVariable ("id") Integer id){
        try {
            ProvinceEntity province = new ProvinceEntity();
            province.setId(id);
            province.setName("name");

            this.provinceDao.save(province);
        }
        catch (Exception e){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping (value = "/id" , method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") Integer id){
        if (provinceDao.findOne(id) != null) {
            this.provinceDao.delete(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
