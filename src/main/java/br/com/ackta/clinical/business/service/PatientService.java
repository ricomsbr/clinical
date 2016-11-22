package br.com.ackta.clinical.business.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.model.entity.IPatient;
import br.com.ackta.clinical.model.entity.Patient;
import br.com.ackta.clinical.model.repository.PatientRepository;

@Service
@Transactional
public class PatientService implements IPatientService {

	private PatientRepository repository;

	public PatientService(PatientRepository rep) {
		repository = rep;
	}

	/**
	 * Se o CPF for diferente de null ele não poderá se igual ao de outra
	 * pessoa.
	 *
	 * @param patient
	 */
	private void checkConsistency(IPatient patient) {
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
	public void delete(ObjectId id) {
		IPatient patient = findById(id);
		repository.delete(patient.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPatient> findAll() {
		return (List<IPatient>) (List<?>) repository.findAll();
	}

	@Override
	public IPatient findByCpf(String cpf) {
		// TODO
		return null;
		// return repository.findByCpf(cpf).orElseThrow(() -> new
		// EntityNotFoundException(Patient.class));
	}

	@Override
	public IPatient findById(ObjectId id) {
		return Optional.of(repository.findOne(id)).orElseThrow(() -> new EntityNotFoundException(Patient.class));
	}

	@Override
	public IPatient findByPersonalDataId(ObjectId personalDataId) {
		repository.findByPersonalData_Id(personalDataId);
		return null;
	}

	@Override
	public IPatient save(IPatient newData) {
		checkConsistency(newData);
		final ObjectId id = newData.getId();
		IPatient toSave = null;
		if (Objects.nonNull(id)) { // Update
			toSave = findById(id);
			toSave = toSave.merge(newData);
		} else { // Insert
			toSave = newData;
		}
		return repository.save((Patient) toSave);
	}

}
