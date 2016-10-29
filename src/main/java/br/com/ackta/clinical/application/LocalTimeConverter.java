/*
 * LocalTimeFormatter.java		02/05/2016
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class LocalTimeConverter implements Converter<String, LocalTime> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.Converter#convert(java.lang.
	 * Object)
	 */
	@Override
	public LocalTime convert(String source) {
		return LocalTime.parse(source);
	}

}
