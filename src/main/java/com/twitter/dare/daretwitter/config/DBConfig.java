package com.twitter.dare.daretwitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories("com.twitter.dare.daretwitter.repository")
public class DBConfig extends AbstractMongoConfiguration {

	@Override
	@Primary
	@Bean
	protected String getDatabaseName() {
		return "dare-twitter";
	}

	@Override
	@Primary
	@Bean
	public Mongo mongo() throws Exception {
		MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
		clientOptions.minConnectionsPerHost(1);
		clientOptions.connectionsPerHost(10);
		MongoClientOptions options = clientOptions.build();
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), options);
		return mongoClient;
	}

}
