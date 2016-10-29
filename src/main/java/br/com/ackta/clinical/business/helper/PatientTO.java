/**
 *
 */
package br.com.ackta.clinical.business.helper;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ackta.clinical.model.entity.Gender;
import br.com.ackta.clinical.model.entity.IPatient;
import br.com.ackta.clinical.model.entity.Patient;

public class PatientTO implements IPatient {

	private static final long serialVersionUID = -990559040902854885L;

	private Long id;

	@NotNull(message = "{active.null}")
	private boolean active = true;

	private Long version;

	private String cpf;

	@NotNull(message = "{name.null}")
	private String name;

	private LocalDate birthDate;

	private Gender gender;

	public PatientTO() {
		super();
	}

	public PatientTO(Patient patient1) {
		this();
		if (Objects.nonNull(patient1)) {
			BeanUtils.copyProperties(patient1, this);
		}
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

}
