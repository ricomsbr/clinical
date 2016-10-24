package br.com.ackta.clinical.application.serializer;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import br.com.ackta.clinical.application.SerializableResourceBundleMessageSource;

public class YearMonthSerializer extends com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer {

	/**
	 *
	 */
	private static final long serialVersionUID = 8974897371998291940L;
	/**
	 *
	 */
	private static final String YEAR_MONTH_FORMAT_KEY = "yearMonth.format";

	@Autowired
	private YearMonthSerializer(SerializableResourceBundleMessageSource messageSource) {
		this(null, messageSource);
	}

	public YearMonthSerializer(DateTimeFormatter formatter, SerializableResourceBundleMessageSource messageSource) {
		super(DateTimeFormatter.ofPattern(
				messageSource.getMessage(YEAR_MONTH_FORMAT_KEY, null, null, LocaleContextHolder.getLocale())));
	}

}