/*
 * ObjectNotFoundException.java		27/05/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.business.service.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import br.com.ackta.clinical.model.entity.IPersistable;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
abstract class EntityException extends RuntimeException {

	private static final long serialVersionUID = -2921024874941524787L;

	private static final String SEPARATOR = ".";

	private Class<? extends IPersistable> entityClass;

	private List<String> messageParameters = Collections.emptyList();

	public EntityException(Class<? extends IPersistable> entityClass1) {
		super();
		this.entityClass = entityClass1;
	}

	public EntityException(Class<? extends IPersistable> entityClass1, String... messageParameters1) {
		super();
		this.entityClass = entityClass1;
		this.messageParameters = Arrays.asList(messageParameters1);
	}

	public abstract String getDefaultMessage();

	@Override
	public String getMessage() {
		String result = super.getMessage();
		if (Objects.isNull(result)) {
			String simpleName = entityClass.getSimpleName();
			StringBuffer sb = new StringBuffer().append(simpleName.substring(0, 1).toLowerCase())
					.append(simpleName.substring(1)).append(SEPARATOR).append(getDefaultMessage());
			result = sb.toString();
		}
		return result;
	}

	public List<String> getMessageParameters() {
		return messageParameters;
	}

}
