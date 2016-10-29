package br.com.ackta.clinical.business.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ackta.clinical.business.service.IPatientService;
import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.business.service.exception.EntitytAlreadyExistsException;
import br.com.ackta.clinical.controller.util.ControllerException;
import br.com.ackta.clinical.model.entity.Patient;

@Service
public class PatientHelper {

	private final IPatientService patientService;

	@Autowired
	public PatientHelper(IPatientService service) {
		this.patientService = service;
	}

	public PatientTO save(PatientTO patientTO) {
		patientTO.getId();
		Patient obj = patientTO.getEntity();
		PatientTO result = null;
		try {
			Patient savedElement = patientService.save(obj);
			result = new PatientTO(savedElement);
		} catch (EntitytAlreadyExistsException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return result;
	}

	public ResponseEntity<Void> delete(Long id) {
		try {
			patientService.delete(id);
		} catch (final EntityNotFoundException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return ResponseEntity.ok().build();
	}
}
