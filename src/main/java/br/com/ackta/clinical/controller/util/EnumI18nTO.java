/*
 * MonetaryAmountNode.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.controller.util;

import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import br.com.ackta.clinical.application.SerializableResourceBundleMessageSource;
import br.com.ackta.clinical.model.entity.EnumI18n;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class EnumI18nTO<E extends Enum<E> & EnumI18n<E>> {
	@JsonUnwrapped
	private E enumVar;
	private String key;
	private String keyPrefix;
	private String keySufix;
	private String message;

	public EnumI18nTO(final E enumVar, SerializableResourceBundleMessageSource messageSource) {
		this.enumVar = enumVar;
		this.key = enumVar.getKey(enumVar);
		this.keyPrefix = enumVar.getKeyPrefix(enumVar);
		this.keySufix = enumVar.getKeySufix(enumVar);
		this.message = messageSource.getMessage(key, null, key, LocaleContextHolder.getLocale());
	}

	@JsonGetter("enum")
	public String getName() {
		return enumVar.name();
	}

	@JsonGetter
	public String getKey() {
		return key;
	}

	@JsonGetter
	public String getKeyPrefix() {
		return keyPrefix;
	}

	@JsonGetter
	public String getKeySufix() {
		return keySufix;
	}

	@JsonIgnore
	public E getEnum() {
		return enumVar;
	}

	@JsonGetter
	public String getMessage() {
		return message;
	}

	@JsonSetter("enum")
	public void setEnum(E enumVar) {
		this.enumVar = enumVar;
	}

	@JsonSetter
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonSetter
	public void setKey(String key) {
		this.key = key;
	}

	@JsonSetter
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}

	@JsonSetter
	public void setKeySufix(String keySufix) {
		this.keySufix = keySufix;
	}

}
