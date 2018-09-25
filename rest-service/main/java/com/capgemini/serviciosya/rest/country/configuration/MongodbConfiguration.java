package com.capgemini.serviciosya.rest.country.configuration;


import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories (basePackages = {"com.capgemini.serviciosya.rest.country.repository"})
public class MongodbConfiguration extends AbstractMongoConfiguration {

    @Autowired
    private Environment env;

    public MongodbConfiguration() {
        super();
    }

    @Override
    protected String getDatabaseName() {

        return env.getRequiredProperty("spring.data.mongodb.database");
    }

    @Override
    public Mongo mongo() throws Exception {

        ServerAddress serverAddress = new ServerAddress (env.getRequiredProperty("spring.data.mongodb.host"));
        List<MongoCredential> credentials = new ArrayList<>();
        MongoClientOptions options = new MongoClientOptions.Builder ().build ();
        return new MongoClient(serverAddress, credentials, options);
    }
}
