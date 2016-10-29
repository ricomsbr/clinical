/*
 * FinancialApplication.java		10/04/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import br.com.ackta.clinical.application.security.UserLoginDetailsService;
import br.com.ackta.clinical.model.repository.UserRepository;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
@Configuration
@EntityScan(basePackageClasses = { TestApplication.class, Jsr310JpaConverters.class })
@ComponentScan(basePackages = { "br.com.ackta.clinical" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { ScanExceptForTest.class }) })
@EnableAutoConfiguration
@ScanOnlyForTest
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Bean
	public UserLoginDetailsService userDetailsService() {
		return new UserLoginDetailsService(userRepository);
	}

}
