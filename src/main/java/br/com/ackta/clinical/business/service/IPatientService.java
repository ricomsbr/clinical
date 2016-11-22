package br.com.ackta.clinical.business.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.ackta.clinical.model.entity.IPatient;

public interface IPatientService {
	void delete(ObjectId id);

	List<IPatient> findAll();

	IPatient findByCpf(String cpf);

	IPatient findById(ObjectId id);

	IPatient findByPersonalDataId(ObjectId personalDataId);

	IPatient save(IPatient patient);
}
