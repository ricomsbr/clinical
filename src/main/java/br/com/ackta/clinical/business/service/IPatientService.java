package br.com.ackta.clinical.business.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.ackta.clinical.model.entity.Patient;

public interface IPatientService {
	Patient save(Patient patient);

	List<Patient> findAll();

	Patient findById(ObjectId id);

	void delete(ObjectId id);

	Patient findByCpf(String cpf);
}
