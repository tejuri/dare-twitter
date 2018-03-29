package com.twitter.dare.daretwitter.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories("com.twitter.dare.daretwitter.repository")
public class DBConfig extends AbstractMongoConfiguration {

	@Value("${mongodb.database}")
	private String databaseName;

	@Value("${mongodb.hostname}")
	private String hostname;

	@Value("${mongodb.port}")
	private int port;

	@Value("${mongodb.username}")
	private String username;

	@Value("${mongodb.password}")
	private String password;

	@Override
	@Primary
	@Bean
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	@Primary
	@Bean
	public Mongo mongo() throws Exception {
		MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
		clientOptions.minConnectionsPerHost(1);
		clientOptions.connectionsPerHost(10);
		clientOptions.socketTimeout(120000);
		clientOptions.serverSelectionTimeout(100000);
		List<ServerAddress> seeds = new ArrayList<ServerAddress>();
		seeds.add(new ServerAddress(hostname, port));
		List<MongoCredential> credentials = new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createScramSha1Credential(username, databaseName, password.toCharArray()));
		MongoClientOptions options = clientOptions.build();
		MongoClient mongoClient = new MongoClient(seeds, credentials, options);
		return mongoClient;
	}

}
