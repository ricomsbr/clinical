package br.com.ackta.clinical.business.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.business.service.exception.EntitytAlreadyExistsException;
import br.com.ackta.clinical.model.entity.IPersonalData;
import br.com.ackta.clinical.model.entity.Patient;
import br.com.ackta.clinical.model.entity.PersonalData;
import br.com.ackta.clinical.model.repository.PersonalDataRepository;

@Service
@Transactional
public class PersonalDataService implements IPersonalDataService {

	private PersonalDataRepository repository;

	public PersonalDataService(PersonalDataRepository rep) {
		repository = rep;
	}

	/**
	 * Se o CPF for diferente de null ele não poderá se igual ao de outra
	 * pessoa.
	 *
	 * @param personalData
	 */
	private void checkConsistency(IPersonalData personalData) {

		String cpf = personalData.getCpf();
		if (Objects.nonNull(cpf)) {
			Long countByCpf = repository.countByCpf(cpf);
			if (countByCpf > 0) {
				throw new EntitytAlreadyExistsException(Patient.class, cpf);
			}
		}
	}

	@Override
	public void delete(ObjectId id) {
		IPersonalData personalData = findById(id);
		repository.delete(personalData.getId());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IPersonalData> findAll() {
		return (List<IPersonalData>) (List<?>) repository.findAll();
	}

	@Override
	public IPersonalData findById(ObjectId id) {
		IPersonalData entity = repository.findOne(id);
		return Optional.of(entity).orElseThrow(() -> new EntityNotFoundException(IPersonalData.class));
	}

	@Override
	public IPersonalData save(IPersonalData newData) {
		checkConsistency(newData);
		final ObjectId id = newData.getId();
		IPersonalData toSave = null;
		if (Objects.nonNull(id)) { // Update
			toSave = findById(id);
			toSave = toSave.merge(newData);
		} else { // Insert
			toSave = newData;
		}
		return repository.save((PersonalData) toSave);
	}

}
