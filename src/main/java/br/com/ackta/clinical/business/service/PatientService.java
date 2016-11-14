package br.com.ackta.clinical.business.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.model.entity.Patient;
import br.com.ackta.clinical.model.repository.PatientRepository;

@Service
public class PatientService implements IPatientService {

	private PatientRepository repository;

	public PatientService(PatientRepository rep) {
		repository = rep;
	}

	@Override
	@Transactional
	public Patient save(Patient newData) {
		checkConsistency(newData);
		final ObjectId id = newData.getId();
		Patient toSave = null;
		if (Objects.nonNull(id)) { // Update
			toSave = findById(id);
			toSave = toSave.merge(newData);
		} else { // Insert
			toSave = newData;
		}
		return repository.save(toSave);
	}

	/**
	 * Se o CPF for diferente de null ele não poderá se igual ao de outra
	 * pessoa.
	 *
	 * @param patient
	 */
	private void checkConsistency(Patient patient) {
		// TODO
		// String cpf = patient.toString().getCpf();
		// if (Objects.nonNull(cpf)) {
		// Long countByCpf = repository.countByCpf(cpf);
		// if (countByCpf > 0) {
		// throw new EntitytAlreadyExistsException(Patient.class, cpf);
		// }
		// }
	}

	@Override
	@Transactional
	public List<Patient> findAll() {
		return repository.findAll();
	}

	@Override
	public Patient findById(ObjectId id) {
		return Optional.of(repository.findOne(id)).orElseThrow(() -> new EntityNotFoundException(Patient.class));
	}

	@Override
	public void delete(ObjectId id) {
		Patient patient = findById(id);
		repository.delete(patient.getId());
	}

	@Override
	public Patient findByCpf(String cpf) {
		// TODO
		return null;
		// return repository.findByCpf(cpf).orElseThrow(() -> new
		// EntityNotFoundException(Patient.class));
	}

}
