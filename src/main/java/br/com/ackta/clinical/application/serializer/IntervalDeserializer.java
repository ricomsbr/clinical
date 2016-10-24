package br.com.ackta.clinical.application.serializer;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

import org.threeten.extra.Interval;

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
public class IntervalDeserializer extends JsonDeserializer<Interval> {

    @Override
    public Interval deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        final IntervalNode node = parser.readValueAs(IntervalNode.class);
    	final Instant start = node.getStart();
		final Instant end = node.getEnd();
        Interval result = null;
		if (Objects.nonNull(start) && Objects.nonNull(end)) {
			result = Interval.of(start, end);
        }
        return result;
    }
}