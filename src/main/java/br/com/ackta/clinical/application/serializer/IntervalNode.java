package br.com.ackta.clinical.application.serializer;

import java.time.Instant;

/**
 * 
 * 
 * @author	RMendonca
 * @version @version@
 * @since	@since@
 */
public class IntervalNode {
	private Instant start;
	private Instant end;
	
	public IntervalNode() {
		super();
	}
	
	public IntervalNode(Instant start, Instant end) {
		this();
		this.start = start;
		this.end = end;
	}
	public Instant getStart() {
		return start;
	}
	public Instant getEnd() {
		return end;
	}
	
}
