/*
 * ObjectNotFoundException.java		27/05/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
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
public class EntitytAlreadyExistsException extends EntityException {

	private static final long serialVersionUID = 6560558653342492493L;

	public static final String ALREADY_EXISTS_MSG = "alreadyExists";

	public EntitytAlreadyExistsException(Class<? extends IPersistable> entityClass1) {
		super(entityClass1);
	}

	public EntitytAlreadyExistsException(Class<? extends IPersistable> entityClass1, String... messageParameters) {
		super(entityClass1, messageParameters);
	}

	@Override
	public String getDefaultMessage() {
		return ALREADY_EXISTS_MSG;
	}

}
