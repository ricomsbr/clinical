package br.com.ackta.clinical.business.helper;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ackta.clinical.business.service.IPatientService;
import br.com.ackta.clinical.business.service.IPersonalDataService;
import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.business.service.exception.EntitytAlreadyExistsException;
import br.com.ackta.clinical.controller.util.ControllerException;
import br.com.ackta.clinical.model.entity.IPatient;
import br.com.ackta.clinical.model.entity.IPersonalData;
import br.com.ackta.clinical.model.entity.Patient;
import br.com.ackta.clinical.model.entity.PersonalData;

@Service
public class PatientHelper {

	private final IPatientService patientService;
	private IPersonalDataService personalDataService;

	@Autowired
	public PatientHelper(IPatientService service, IPersonalDataService personalDataService1) {
		this.patientService = service;
		this.personalDataService = personalDataService1;
	}

	public ResponseEntity<Void> delete(ObjectId id) {
		try {
			patientService.delete(id);
		} catch (final EntityNotFoundException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return ResponseEntity.ok().build();
	}

	public PatientTO save(PersonalDataTO personalDataTO) {
		personalDataTO.getId();
		PersonalData personalData = personalDataTO.getEntity();
		PatientTO result = null;
		try {
			IPersonalData persisted = personalDataService.save(personalData);
			IPatient patient = new Patient(persisted);
			IPatient persistedElement = patientService.save(patient);
			result = new PatientTO(persistedElement);
		} catch (EntitytAlreadyExistsException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return result;
	}
}
