/*
 * CurrencyUnitSerializer.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import java.io.IOException;
import java.util.Currency;

import javax.money.CurrencyUnit;

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
public class CurrencyUnitSerializer extends JsonSerializer<CurrencyUnit> {

	@Override
	public void serialize(final CurrencyUnit value, final JsonGenerator generator, final SerializerProvider serializers)
			throws IOException {
		final String currencyCode = value.getCurrencyCode();
		final Currency currency = Currency.getInstance(currencyCode);
		final CurrencyUnitNode node = new CurrencyUnitNode(currencyCode, currency.getSymbol(),
				currency.getDisplayName());
		generator.writeObject(node);

	}
}