package br.com.ackta.clinical.application.serializer;

import java.io.IOException;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 
 * 
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
public class CurrencyUnitDeserializer extends JsonDeserializer<CurrencyUnit> {

    @Override
    public CurrencyUnit deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final CurrencyUnitNode node = parser.readValueAs(CurrencyUnitNode.class);
        return Monetary.getCurrency(node.getCode());
    }
}