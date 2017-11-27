package com.twitter.dare.daretwitter.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dare.daretwitter.services.HomeService;

@RestController
public class HomeController {

	@RequestMapping(value = "/rest/home", method = RequestMethod.POST)
	public void streamVideo() {
		
		HomeService homeService = new HomeService();
		try {
			homeService.streamVideo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}