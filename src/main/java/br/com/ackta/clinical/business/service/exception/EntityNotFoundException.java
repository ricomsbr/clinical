/*
 * ObjectNotFoundException.java		27/05/2015
 *
 * Copyright (C) 2015 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.business.service.exception;

import br.com.ackta.clinical.model.entity.IPersistable;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class EntityNotFoundException extends EntityException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3705193673125045928L;

	public static final String NOT_FOUND_MSG = "notFound";

	public EntityNotFoundException(Class<? extends IPersistable> entityClass1) {
		super(entityClass1);
	}

	@Override
	public String getDefaultMessage() {
		return NOT_FOUND_MSG;
	}
}
