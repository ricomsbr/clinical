/*
 * CommonControllerAdviser.java		19/10/2015
 *
 * Copyright (C) 2015 FAPESP. All Rights Reserved.
 */
package br.com.ackta.clinical.application.adviser;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ackta.clinical.application.SerializableResourceBundleMessageSource;
import br.com.ackta.clinical.controller.util.ControllerException;
import br.com.ackta.clinical.controller.util.ErrorTO;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
@ControllerAdvice
class CommonControllerAdviser extends ResponseEntityExceptionHandler {
	public static final String SEPARATOR = ".";

	@Autowired
	SerializableResourceBundleMessageSource messageSource;

	@Autowired
	SerializableResourceBundleMessageSource messageSourceIntranet;

	@ExceptionHandler(value = ControllerException.class)
	public ResponseEntity<Object> objectFoundExceptionHandler(ControllerException ex, WebRequest request) {
		final HttpStatus responseStatus = ex.getStatusCode();
		String simpleName = ex.getControllerClass().getSimpleName();
		String str = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
		String msg = str + SEPARATOR + ex.getMessage();
		return defaultHandle(ex, msg, request, responseStatus, ex.getArguments());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> validationExceptionHandler(ConstraintViolationException ex, WebRequest request) {
		return defaultHandle(ex, ex.getMessage(), request, HttpStatus.BAD_REQUEST, null);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> defaultExceptionHandler(Exception ex, WebRequest request) {
		final Object[] args = null;
		final String key = ex.getMessage();
		final String msg = messageSource.getMessage(key, args,
				messageSourceIntranet.getMessage(key, args, key, LocaleContextHolder.getLocale()),
				LocaleContextHolder.getLocale());
		logger.error("Exception message: " + msg, ex);
		final ResponseEntity<Object> result = this.handleException(ex, request);
		return result;
	}

	private ResponseEntity<Object> defaultHandle(Exception ex, String key, WebRequest request, HttpStatus httpStatus,
			Object[] args) {
		// final String key = ex.getMessage();
		final String msg = messageSource.getMessage(key, args,
				messageSourceIntranet.getMessage(key, args, key, LocaleContextHolder.getLocale()),
				LocaleContextHolder.getLocale());
		logger.warn("Exception message: " + msg, ex);
		final ErrorTO error = new ErrorTO(msg);
		return (this.handleExceptionInternal(ex, error, new HttpHeaders(), httpStatus, request));
	}

}