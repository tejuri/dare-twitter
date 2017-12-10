package com.twitter.dare.daretwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dare.daretwitter.models.LoginRequestVO;
import com.twitter.dare.daretwitter.models.User;
import com.twitter.dare.daretwitter.repository.UserRepository;
import com.twitter.dare.daretwitter.services.LoginService;

@RestController
@CrossOrigin(value = "*")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/rest/login", method = RequestMethod.POST)
	@Cacheable(value = "user", key = "", unless = "#result == null")
	public ResponseEntity<User> doLogin(@RequestBody LoginRequestVO loginRequestVO) {
		System.out.println(loginRequestVO.toString() + " " + (userRepository == null));
		return new ResponseEntity<User>(loginService.loginWithUsernamePasswordCredential(loginRequestVO),
				HttpStatus.OK);

	}
}
