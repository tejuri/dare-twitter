package com.twitter.dare.daretwitter.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class AddressVO {

	@Field("city")
	String city;

	@Field("state")
	String state;

	@Field("country")
	String country;

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

	@Override
	public String toString() {
		return "AddressVO [city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
