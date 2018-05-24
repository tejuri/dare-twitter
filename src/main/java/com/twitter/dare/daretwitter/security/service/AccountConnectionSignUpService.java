package com.twitter.dare.daretwitter.security.service;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

import com.twitter.dare.daretwitter.repository.UserRepository;

public class AccountConnectionSignUpService implements ConnectionSignUp {

	private final UserRepository userRepository;

	public AccountConnectionSignUpService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String execute(Connection<?> connection) {
		org.springframework.social.connect.UserProfile profile = connection.fetchUserProfile();

		System.out.println(profile.getEmail() + " " + profile.getFirstName() + " " + profile.getLastName() + " "
				+ profile.getUsername());

		/**
		 * insert a new user in your database
		 */

		return "";
	}
}