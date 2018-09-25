package com.capgemini.serviciosya.rest.country.repository;

import com.capgemini.serviciosya.rest.country.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends MongoRepository <Country,Integer> {
}
