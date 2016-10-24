/*
 * MonetaryAmountNode.java		27/10/2015
 * 
 * Copyright (C) 2015 FAPESP. All Rights Reserved.
 */
package br.com.ackta.clinical.application.serializer;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
public class MonetaryAmountNode {
    private final BigDecimal amount;

    private final CurrencyUnit currency;

    @JsonCreator
    MonetaryAmountNode(@JsonProperty("amount") final BigDecimal amount,
            @JsonProperty("currency") final CurrencyUnit currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @JsonGetter("amount")
    BigDecimal getAmount() {
        return amount;
    }

    @JsonGetter("currency")
    CurrencyUnit getCurrency() {
        return currency;
    }

}
