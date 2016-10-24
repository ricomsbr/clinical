/*
 * ObjectNotFoundException.java		27/05/2015
 *
 * Copyright (C) 2015 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.business.service.exception;

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

	public Class<? extends IPersistable> entityClass;

	public EntityException(Class<? extends IPersistable> entityClass1) {
		super();
		this.entityClass = entityClass1;
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
}
