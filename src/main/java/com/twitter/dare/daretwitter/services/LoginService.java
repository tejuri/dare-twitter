package com.twitter.dare.daretwitter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.twitter.dare.daretwitter.models.LoginRequestVO;
import com.twitter.dare.daretwitter.models.QUser;
import com.twitter.dare.daretwitter.models.User;
import com.twitter.dare.daretwitter.repository.UserRepository;

@Service
@Scope(value = "prototype")
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public User loginWithUsernamePasswordCredential(LoginRequestVO loginRequestVO) {
		QUser qUserDO = new QUser("user");
		Predicate predicate = qUserDO.email.eq("gauravsonkar597@gmail.com");
		// List<User> users = (List<User>) userRepository.findAll(predicate);
		System.out.println("hello world");
		return userRepository.findOne(predicate);
	}
}
