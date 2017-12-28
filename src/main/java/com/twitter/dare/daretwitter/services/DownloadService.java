package com.twitter.dare.daretwitter.services;

import java.io.InputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Service
@Scope(value = "prototype")
public class DownloadService {

	private static String bucketName = "";
	private static String objectKey = "";
	S3Object s3object = null;

	public InputStreamResource streamVideo() {
		@SuppressWarnings("deprecation")
		AmazonS3 s3Client = new AmazonS3Client();
		try {
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, objectKey);
			s3object = s3Client.getObject(getObjectRequest);
		} catch (Exception ex) {

		}
		InputStream inputStream = s3object.getObjectContent();
		return new InputStreamResource(inputStream);

	}

}
