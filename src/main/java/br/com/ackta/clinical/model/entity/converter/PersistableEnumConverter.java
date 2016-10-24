/*
 * AccountTypeConverter.java		10/05/2016
 *
 * Copyright (C) 2015 ACKTA. All Rights Reserved.
 */
package br.com.ackta.clinical.model.entity.converter;

import javax.persistence.AttributeConverter;

import br.com.ackta.clinical.model.entity.IPersistableEnum;

/**
 *
 *
 * @author RMendonca
 * @version @version@
 * @since @since@
 */
public interface PersistableEnumConverter<E extends IPersistableEnum> extends AttributeConverter<E, Long> {
	@Override
	default public Long convertToDatabaseColumn(E attribute) {
		return attribute.getId();
	}

}
