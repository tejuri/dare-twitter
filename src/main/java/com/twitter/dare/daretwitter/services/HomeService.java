package com.twitter.dare.daretwitter.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class HomeService {

	private static String bucketName = "dare-twitter";
	private static String key = "Youtube's Smallest Video.mp4";

	public void streamVideo() throws IOException {
		AmazonS3 s3Client = new AmazonS3Client(
				new BasicAWSCredentials("AKIAIRLAUAYEO4ILJIMQ", "zjIYgjSWjkscvKEEmX0mzw3L6q2669ae4FSXy5Sa"));
		S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, key));
		BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object.getObjectContent()));

		while (true) {
			String line;
			line = reader.readLine();
			if (line == null)
				break;
			System.out.println(line);
		}
	}

}
