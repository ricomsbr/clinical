/**
 *
 */
package br.com.ackta.clinical.business.helper;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ackta.clinical.model.entity.IPatient;
import br.com.ackta.clinical.model.entity.IPersonalData;
import br.com.ackta.clinical.model.entity.Patient;

public class PatientTO implements IPatient {

	private static final long serialVersionUID = -990559040902854885L;

	private ObjectId id;

	@NotNull(message = "{active.null}")
	private boolean active = true;

	private Long version;

	@NotNull(message = "{personalData.null}")
	private IPersonalData personalData;

	public PatientTO() {
		super();
	}

	public PatientTO(IPatient patient1) {
		this();
		if (Objects.nonNull(patient1)) {
			BeanUtils.copyProperties(patient1, this);
		}
		PersonalDataTO personalDataTO = new PersonalDataTO(patient1.getPersonalData());
		setPersonalDate(personalDataTO);
	}

	/**
	 * @return
	 */
	@JsonIgnore
	public Patient getEntity() {
		final Patient result = new Patient();
		BeanUtils.copyProperties(this, result);
		return result;
	}

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public IPersonalData getPersonalData() {
		return personalData;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setPersonalDate(IPersonalData personalData) {
		this.personalData = personalData;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}

}
