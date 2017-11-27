package com.twitter.dare.daretwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class DareTwitterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DareTwitterApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DareTwitterApplication.class);
	}
}