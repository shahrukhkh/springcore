package com.khan.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserDetailsService detailsService;

	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration authConfig) 
					throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(encoder);
		authenticationProvider.setUserDetailsService(detailsService);
		return authenticationProvider;
	}
	@Bean
	SecurityFilterChain configureAuth(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(
				request -> request.requestMatchers("/home","/","/user/**").permitAll()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				.requestMatchers("/customer").hasAuthority("CUSTOMER")
				.anyRequest().authenticated()
				)
			.formLogin(
					form -> form.loginPage("/login").permitAll()
								.defaultSuccessUrl("/home",true)
					)
			.logout(logout->logout.permitAll());
		return http.build();
	}
}
