package com.twitter.dare.twitter.models;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mysema.query.annotations.QueryEntity;
import com.twitter.dare.daretwitter.models.AddressVO;

@QueryEntity
@Document(collection = "user")
public class User {

	@Id
	String id;

	@Field("first_name")
	String firstName;

	@Field("last_name")
	String lastName;

	@Field("email")
	String email;

	@Field("phone_number")
	long phoneNumber;

	@Field("address")
	ArrayList<AddressVO> addressVOs;

	@Field("followers")
	ArrayList<String> followers;

	@Field("following")
	ArrayList<String> following;

	@Field("rating")
	double rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ArrayList<AddressVO> getAddressVOs() {
		return addressVOs;
	}

	public void setAddressVOs(ArrayList<AddressVO> addressVOs) {
		this.addressVOs = addressVOs;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<String> followers) {
		this.followers = followers;
	}

	public ArrayList<String> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<String> following) {
		this.following = following;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", addressVOs=" + addressVOs + ", followers=" + followers
				+ ", following=" + following + ", rating=" + rating + "]";
	}

}
