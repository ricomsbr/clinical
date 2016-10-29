/*
 * MonetaryAmountDeserializer.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import java.io.IOException;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class MonetaryAmountDeserializer extends JsonDeserializer<MonetaryAmount> {
	MonetaryAmountFactory factory;

	public MonetaryAmountDeserializer(MonetaryAmountFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public MonetaryAmount deserialize(final JsonParser parser, final DeserializationContext context)
			throws IOException {
		final MonetaryAmountNode node = parser.readValueAs(MonetaryAmountNode.class);
		return Money.of(node.getAmount(), node.getCurrency());
	}

}