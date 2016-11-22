package br.com.ackta.clinical.business.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.ackta.clinical.model.entity.IPersonalData;

public interface IPersonalDataService {

	void delete(ObjectId id);

	List<IPersonalData> findAll();

	IPersonalData findById(ObjectId id);

	IPersonalData save(IPersonalData newData);

}
