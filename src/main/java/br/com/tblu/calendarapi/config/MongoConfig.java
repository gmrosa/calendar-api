package br.com.tblu.calendarapi.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongodb.host}")
    private String host;

    @Override
    public MongoClient mongoClient() {
        String port = "27017";
        String conString = "mongodb://" + host + ":" + port + "/?authSource=admin";
        MongoClient mClient = MongoClients.create(conString);
        return mClient;

    }

    @Override
    protected String getDatabaseName() {
        return "calendar";
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mt = new MongoTemplate(mongoClient(), getDatabaseName());
        return mt;
    }

}