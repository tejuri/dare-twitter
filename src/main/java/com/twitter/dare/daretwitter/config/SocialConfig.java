package com.twitter.dare.daretwitter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.twitter.dare.daretwitter.repository.UserRepository;
import com.twitter.dare.daretwitter.security.service.AccountConnectionSignUpService;
import com.twitter.dare.daretwitter.security.service.FacebookSignInAdapter;

@Configuration
@EnableSocial
@CrossOrigin(value = "*")
public class SocialConfig implements SocialConfigurer {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {

		connectionFactoryConfigurer.addConnectionFactory(
				new GoogleConnectionFactory("446753341543-2m2pvj8c308kkbokl1ghtinkmgk0rsrd.apps.googleusercontent.com",
						"dEe44w0lidW3p0ih020CoEIN"));

	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator arg0) {

		return null;
	}

	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator,
			UsersConnectionRepository usersConnectionRepository) {

		((InMemoryUsersConnectionRepository) usersConnectionRepository)
				.setConnectionSignUp(new AccountConnectionSignUpService(userRepository));
		ProviderSignInController providerSignInController = new ProviderSignInController(connectionFactoryLocator,
				usersConnectionRepository, new FacebookSignInAdapter());
		providerSignInController.setPostSignInUrl("http://localhost:8081/rest/download");
		return providerSignInController;
	}

}