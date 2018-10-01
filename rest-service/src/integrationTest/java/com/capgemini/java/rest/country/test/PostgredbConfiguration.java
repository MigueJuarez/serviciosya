package com.capgemini.java.rest.country.test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@Configuration
@EnableJpaRepositories(basePackages = {"com.capgemeini.serviciosya.dao"})
public class PostgredbConfiguration {  //PUEDE QUE FALTE UN EXTENDS

    private Environment environment;

    public PostgredbConfiguration(){

        super();
    }
    /*
    @Bean
    public String postgre(){
        ServerAddress serverAddress = new ServerAddress (environment.getRequiredProperty ("spring.data.mongodb.host"));
        List<PostgreCredential> credentials = new ArrayList<>();
        MongoClientOptions     options = new MongoClientOptions.Builder ().build ();
    }

    */
}
