/**
 *
 */
package br.com.ackta.clinical.controller.patient;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ackta.clinical.business.helper.PatientHelper;
import br.com.ackta.clinical.business.helper.PatientTO;

@RestController(value = "patientController")
@RequestMapping(value = "/patient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
// @Validated
public class PatientController {

	private final PatientHelper helper;

	private static Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	public PatientController(PatientHelper helper1) {
		this.helper = helper1;
	}

	@RequestMapping(method = RequestMethod.POST)
	public PatientTO save(@RequestBody @Valid PatientTO patientTO) {

		LOGGER.info("Method save initialized. Set size: [{}] ", new Object[] { patientTO });
		PatientTO result = null;
		result = helper.save(patientTO);
		LOGGER.debug("[{}] itens saved as Patient.", result);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		LOGGER.info("Method delete initialized. Remove patient id ", new Object[] { id });
		ResponseEntity<Void> result = helper.delete(id);
		return result;
	}
}
