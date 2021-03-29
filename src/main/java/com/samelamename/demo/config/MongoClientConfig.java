package com.samelamename.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfig {
        public @Bean
        MongoClient mongoClient() {
            return MongoClients.create();
        }
}
