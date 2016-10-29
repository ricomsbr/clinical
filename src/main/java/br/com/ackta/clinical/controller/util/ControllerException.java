/*
 * ControllerException.java		22/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.controller.util;

import org.springframework.http.HttpStatus;

/**
 *
 *
 * @author rmendonca
 * @version @version@
 * @since @since@
 */
public class ControllerException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 3642247277080906177L;

	private final HttpStatus statusCode;

	private Object[] arguments;

	private Class<?> controllerClass;

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public Object[] getArguments() {
		return arguments;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public void setControllerClass(Class<?> controllerClass) {
		this.controllerClass = controllerClass;
	}

	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

	/**
	 * @param arg0
	 */

	public ControllerException(HttpStatus httpStatus, Class<?> controllerClass1, Throwable arg0) {
		super(arg0.getMessage());
		this.statusCode = httpStatus;
		this.controllerClass = controllerClass1;
	}

	public ControllerException(HttpStatus httpStatus, Class<?> controllerClass1, String msg) {
		super(msg);
		this.statusCode = httpStatus;
		this.controllerClass = controllerClass1;
	}

	public ControllerException(HttpStatus httpStatus, Class<?> controllerClass1, String msg, Throwable arg0) {
		super(msg, arg0);
		this.statusCode = httpStatus;
		this.controllerClass = controllerClass1;
	}

	public ControllerException(HttpStatus httpStatus, Class<?> controllerClass1, String msg, Throwable arg0,
			Object... arguments) {
		this(httpStatus, controllerClass1, msg, arg0);
		this.arguments = arguments;
		this.controllerClass = controllerClass1;
	}

	public ControllerException(HttpStatus httpStatus, Class<?> controllerClass1, String msg, Object... arguments) {
		this(httpStatus, controllerClass1, msg);
		this.arguments = arguments;
		this.controllerClass = controllerClass1;
	}

}
