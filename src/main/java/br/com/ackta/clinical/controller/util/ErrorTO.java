/*
 * ErrorTO.java		03/11/2015
 * 
 * Copyright (C) 2015 FAPESP. All Rights Reserved.
 */
package br.com.ackta.clinical.controller.util;

/**
 * 
 * 
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
public class ErrorTO {
	private final String message;

	/**
	 * @param message
	 */
	public ErrorTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
