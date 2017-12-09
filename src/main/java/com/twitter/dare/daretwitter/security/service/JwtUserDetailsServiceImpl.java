package com.twitter.dare.daretwitter.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.twitter.dare.daretwitter.repository.UserRepository;
import com.twitter.dare.daretwitter.security.JwtUser;
import com.twitter.dare.twitter.models.QUser;
import com.twitter.dare.twitter.models.User;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		QUser qUserDO = new QUser("user");
		Predicate predicate = qUserDO.email.eq("gauravsonar597@gmail.com");
		User loginUser = userRepository.findOne(predicate);

		List<GrantedAuthority> loginUserGrantedAuthorities = new ArrayList<GrantedAuthority>();

		if (loginUser == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			return new JwtUser((long) loginUser.getPhoneNumber(), loginUser.getEmail(), "", "", "",
					loginUser.getFirstName(), loginUserGrantedAuthorities, true, new Date());
		}
	}

	/*
	 * public static List<GrantedAuthority> getMyGrantedAuthorities(Collection<Role>
	 * roles) {
	 * 
	 * List<GrantedAuthority> collection = new ArrayList<>(); for (Role role :
	 * roles) { collection.add(new SimpleGrantedAuthority(role.getRoleName())); }
	 * 
	 * return collection; }
	 */
}
