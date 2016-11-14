/*
 * WebSecurity.java		23/06/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.ackta.clinical.application.security.UserLoginDetailsService;
import br.com.ackta.clinical.model.repository.UserRepository;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@ScanExceptForTest
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserRepository userRepository) throws Exception {
		auth.userDetailsService(new UserLoginDetailsService(userRepository));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().httpBasic().and()
				.csrf().disable();
	}
}
