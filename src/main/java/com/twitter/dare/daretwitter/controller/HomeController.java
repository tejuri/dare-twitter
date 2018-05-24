package com.twitter.dare.daretwitter.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dare.daretwitter.models.UrlResponseVO;
import com.twitter.dare.daretwitter.services.HomeService;

@RestController
@CrossOrigin(value = "*")
public class HomeController {

	@RequestMapping(value = "/rest/home", method = RequestMethod.GET)
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