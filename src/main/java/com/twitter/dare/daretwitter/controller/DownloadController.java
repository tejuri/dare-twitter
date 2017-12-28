package com.twitter.dare.daretwitter.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.dare.daretwitter.services.DownloadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(value = "*", origins = "*")
public class DownloadController {

	@Autowired
	DownloadService downloadService;

	@RequestMapping(value = "/rest/download", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> streamVideo() {
		System.out.println("hello world");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept-Ranges", "bytes");
		headers.add("Content-Type", "video/mp4");
		headers.add("Content-Length", "14948781");
		return new ResponseEntity<InputStreamResource>(downloadService.streamVideo(), headers, HttpStatus.OK);
	}

}
