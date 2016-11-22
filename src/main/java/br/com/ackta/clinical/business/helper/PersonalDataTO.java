package br.com.ackta.clinical.business.helper;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ackta.clinical.model.entity.Gender;
import br.com.ackta.clinical.model.entity.IPersonalData;
import br.com.ackta.clinical.model.entity.PersonalData;

public class PersonalDataTO implements IPersonalData {

	private static final long serialVersionUID = -4909408341248192478L;

	@NotNull(message = "{active.null}")
	private boolean active;

	private LocalDate birthDate;

	private String cpf;

	private Gender gender;

	private ObjectId id;

	@NotNull(message = "{name.null}")
	private String name;

	private String rg;

	private Long version;

	public PersonalDataTO() {
		super();
	}

	public PersonalDataTO(IPersonalData newData) {
		this();
		if (Objects.nonNull(newData)) {
			BeanUtils.copyProperties(newData, this);
		}
	}

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String getCpf() {
		return cpf;
	}

	/**
	 * @return
	 */
	@JsonIgnore
	public PersonalData getEntity() {
		final PersonalData result = new PersonalData();
		BeanUtils.copyProperties(this, result);
		return result;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getRg() {
		return rg;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}
}
