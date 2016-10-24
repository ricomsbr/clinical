/*
 * MoneyFactory.java		27/10/2015
 * 
 * Copyright (C) 2015 FAPESP. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * 
 * 
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
public final class MoneyFactory implements MonetaryAmountFactory {

    @Override
    public MonetaryAmount create(final BigDecimal amount, final CurrencyUnit currency) {
        return Money.of(amount, currency);
    }

}