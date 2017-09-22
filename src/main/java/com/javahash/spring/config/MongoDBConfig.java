package com.javahash.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.javahash.spring.dao.repository.EmployeeRepositoryCustomQueryDsl;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.javahash.spring.dao.repository")
public class MongoDBConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "tvshows";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1");
	}
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}
 
	@Bean(name="mongoTemplate")
	public MongoTemplate mongoTemplate() throws Exception {
 		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
 		return mongoTemplate;
 
	}
		
	
}