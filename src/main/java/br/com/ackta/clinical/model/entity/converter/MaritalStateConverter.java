package br.com.ackta.clinical.model.entity.converter;

import br.com.ackta.clinical.model.entity.MaritalState;

public class MaritalStateConverter implements PersistableEnumConverter<MaritalState> {

	@Override
	public MaritalState convertToEntityAttribute(Long dbData) {
		return MaritalState.findById(dbData);
	}

}
