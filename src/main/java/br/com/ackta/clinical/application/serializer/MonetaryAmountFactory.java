/*
 * MonetaryAmountFactory.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

/**
 *
 *
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

public interface MonetaryAmountFactory {

	MonetaryAmount create(final BigDecimal amount, final CurrencyUnit currency);

}