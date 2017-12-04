package com.twitter.dare.daretwitter.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dare.daretwitter.services.HomeService;
import com.twitter.dare.twitter.models.UrlResponseVO;

@RestController
public class HomeController {

	@RequestMapping(value = "/rest/home", method = RequestMethod.POST)
	public ResponseEntity<UrlResponseVO> streamVideo() {

		HomeService homeService = new HomeService();
		try {
			return new ResponseEntity<UrlResponseVO>(new UrlResponseVO(homeService.streamVideo()), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<UrlResponseVO>(HttpStatus.NOT_FOUND);
		}
	}

}