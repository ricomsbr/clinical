package br.com.ackta.clinical.business.service;

import java.util.List;

import br.com.ackta.clinical.model.entity.Patient;

public interface IPatientService {
	Patient save(Patient patient);

	List<Patient> findAll();

	Patient findById(Long id);

	void delete(Long id);

	Patient findByCpf(String cpf);
}
