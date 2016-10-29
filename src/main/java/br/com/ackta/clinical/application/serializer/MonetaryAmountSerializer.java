/*
 * MonetaryAmountSerializer.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import java.io.IOException;
import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class MonetaryAmountSerializer extends JsonSerializer<MonetaryAmount> {

	@Override
	public void serialize(final MonetaryAmount value, final JsonGenerator generator, final SerializerProvider provider)
			throws IOException {
		final BigDecimal amount = value.getNumber().numberValueExact(BigDecimal.class);
		final CurrencyUnit currency = value.getCurrency();
		generator.writeObject(new MonetaryAmountNode(amount, currency));
	}
}