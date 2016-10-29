/*
 * MonetaryAmountDecimalMinValidator.java		22/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.controller.validators;

/**
 *
 * @author	rmendonca
 * @version @version@
 * @since	@since@
 */
import java.math.BigDecimal;

import javax.money.MonetaryAmount;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.DecimalMax;

public class MonetaryAmountDecimalMaxValidator implements ConstraintValidator<DecimalMax, MonetaryAmount> {

	private BigDecimal maxValue;

	private boolean inclusive;

	@Override
	public void initialize(final DecimalMax annotation) {
		this.maxValue = new BigDecimal(annotation.value());
		this.inclusive = annotation.inclusive();
	}

	@Override
	public boolean isValid(final MonetaryAmount value, final ConstraintValidatorContext context) {
		// null values are valid
		if (value == null) {
			return true;
		}

		final BigDecimal amount = value.getNumber().numberValueExact(BigDecimal.class);
		final int comparisonResult = amount.compareTo(maxValue);
		return inclusive ? comparisonResult <= 0 : comparisonResult < 0;
	}
}