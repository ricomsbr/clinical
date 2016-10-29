/*
 * MonetaryAmountNode.java		27/10/2015
 *
 * Copyright (C) 2016 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public class CurrencyUnitNode {
	private final String code;
	private final String symbol;
	private final String displayName;

	@JsonCreator
	CurrencyUnitNode(@JsonProperty("code") final String code, @JsonProperty("symbol") final String symbol,
			@JsonProperty("displayName") final String displayName) {
		this.code = code;
		this.symbol = symbol;
		this.displayName = displayName;
	}

	@JsonGetter("code")
	String getCode() {
		return code;
	}

	@JsonGetter("symbol")
	String getSymbol() {
		return symbol;
	}

	@JsonGetter("displayName")
	String getDisplayName() {
		return displayName;
	}
}
