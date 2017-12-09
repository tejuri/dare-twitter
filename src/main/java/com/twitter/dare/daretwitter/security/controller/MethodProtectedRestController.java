package com.twitter.dare.daretwitter.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodProtectedRestController {

	@RequestMapping(value = "protected", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public ResponseEntity<?> getProtectedGreeting() {
		return ResponseEntity.ok("Greetings from admin protected method!");
	}

}