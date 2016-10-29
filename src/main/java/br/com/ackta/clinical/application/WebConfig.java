/*
 * WebConfig.java		28/07/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.threeten.extra.Interval;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import br.com.ackta.clinical.application.serializer.CurrencyUnitDeserializer;
import br.com.ackta.clinical.application.serializer.CurrencyUnitSerializer;
import br.com.ackta.clinical.application.serializer.IntervalDeserializer;
import br.com.ackta.clinical.application.serializer.IntervalSerializer;
import br.com.ackta.clinical.application.serializer.MonetaryAmountDeserializer;
import br.com.ackta.clinical.application.serializer.MonetaryAmountSerializer;
import br.com.ackta.clinical.application.serializer.MoneyFactory;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	/**
	 *
	 */
	private static final Locale DEFAULT_LOCALE = new Locale("pt", "BR");

	// @Autowired
	// private EmailConfig emailConfig;

	@Autowired
	private ObjectMapper objectMapper;

	@Bean
	public RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		final MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonMessageConverter.setObjectMapper(objectMapper);
		messageConverters.add(jsonMessageConverter);
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}

	@Bean
	@ConfigurationPropertiesBinding
	public LocalTimeConverter localTimeConverter() {
		return new LocalTimeConverter();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		final LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	@Bean
	public LocaleResolver localeResolver() {
		final SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(DEFAULT_LOCALE);
		return resolver;
	}

	@Bean
	public CurrencyUnit defaultCurrency() {
		return Monetary.getCurrency(DEFAULT_LOCALE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addInterceptors(org.springframework.web.servlet.config.annotation.
	 * InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public Module module() {
		final SimpleModule module = new SimpleModule();
		module.addSerializer(CurrencyUnit.class, new CurrencyUnitSerializer());
		module.addSerializer(MonetaryAmount.class, new MonetaryAmountSerializer());
		module.addSerializer(Interval.class, new IntervalSerializer());
		module.addDeserializer(CurrencyUnit.class, new CurrencyUnitDeserializer());
		module.addDeserializer(MonetaryAmount.class, new MonetaryAmountDeserializer(new MoneyFactory()));
		module.addDeserializer(Interval.class, new IntervalDeserializer());
		return module;
	}

	@Bean
	public SerializableResourceBundleMessageSource messageSource() {
		final SerializableResourceBundleMessageSource serializableResourceBundleMessageSource = new SerializableResourceBundleMessageSource();
		serializableResourceBundleMessageSource.setBasename("classpath:/i18n/msgs");
		return serializableResourceBundleMessageSource;
	}

	@Bean
	public SerializableResourceBundleMessageSource messageSourceIntranet() {
		final SerializableResourceBundleMessageSource serializableResourceBundleMessageSource = new SerializableResourceBundleMessageSource();
		serializableResourceBundleMessageSource.setBasename("classpath:/i18n/msgsIntranet");
		return serializableResourceBundleMessageSource;
	}

	// @Bean
	// public JavaMailSenderImpl mailSender() {
	// final JavaMailSenderImpl result = new JavaMailSenderImpl();
	// result.setHost(emailConfig.getHost());
	// return result;
	// }
}
