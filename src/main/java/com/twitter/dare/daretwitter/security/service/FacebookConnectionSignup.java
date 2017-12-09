package com.twitter.dare.daretwitter.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.twitter.dare.daretwitter.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Connection<?> connection) {
		System.out.println("signup === ");
		// final User user = new User();
		System.out.println(connection.getDisplayName());
		System.out.println(connection.fetchUserProfile().toString());
		// user.setUsername(connection.getDisplayName());
		// user.setPassword(randomAlphabetic(8));
		// userRepository.save(user);
		return connection.getDisplayName();
	}
}