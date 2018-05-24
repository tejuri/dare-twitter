package com.twitter.dare.daretwitter.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mysema.query.annotations.QueryEntity;

@QueryEntity
@Document(collection = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4411993804239988098L;

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

	@Field("city")
	String city;

	@Field("state")
	String state;

	@Field("country")
	String country;

	@Field("followers")
	ArrayList<String> followers;

	@Field("following")
	ArrayList<String> following;

	@Field("rating")
	int rating;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", followers=" + followers + ", following=" + following + ", rating=" + rating + "]";
	}

}
