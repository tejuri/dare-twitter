package com.twitter.dare.daretwitter.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private final Long id;
	private final String username;
	private final String firstname;
	private final String lastname;
	private final String password;
	private final String email;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	private final Date lastPasswordResetDate;

	public JwtUser(Long id, String username, String firstname, String lastname, String email, String password,
			Collection<? extends GrantedAuthority> authorities, boolean enabled, Date lastPasswordResetDate) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.authorities = new ArrayList<GrantedAuthority>(authorities);
		this.enabled = enabled;
		this.lastPasswordResetDate = new Date();
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<? extends GrantedAuthority> tempCollections = this.authorities;
		return tempCollections;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@JsonIgnore
	public Date getLastPasswordResetDate() {
		return (Date) lastPasswordResetDate.clone();
	}

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", email=" + email + ", authorities=" + authorities + ", enabled="
				+ enabled + ", lastPasswordResetDate=" + lastPasswordResetDate + "]";
	}
}
