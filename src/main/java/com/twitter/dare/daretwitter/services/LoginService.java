package com.twitter.dare.daretwitter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.twitter.dare.daretwitter.repository.UserRepository;
import com.twitter.dare.twitter.models.LoginRequestVO;
import com.twitter.dare.twitter.models.QUser;
import com.twitter.dare.twitter.models.User;

@Service
@Scope(value = "prototype")
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public User loginWithUsernamePasswordCredential(LoginRequestVO loginRequestVO) {
		QUser qUserDO = new QUser("user");
		Predicate predicate = qUserDO.email.eq("gauravsonar597@gmail.com");
		// List<User> users = (List<User>) userRepository.findAll(predicate);
		return userRepository.findOne(predicate);
	}
}
