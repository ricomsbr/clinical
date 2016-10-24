package br.com.ackta.clinical.application.serializer;

import java.io.IOException;

import org.threeten.extra.Interval;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class IntervalSerializer extends JsonSerializer<Interval> {

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Interval value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		final IntervalNode node = new IntervalNode(value.getStart(), value.getEnd());
		gen.writeObject(node);
	}

}