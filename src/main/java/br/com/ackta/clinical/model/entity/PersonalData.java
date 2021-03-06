package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PersonalData implements IPersonalData {

	private static final long serialVersionUID = -2383673733659048451L;

	@Id
	private ObjectId id;

	@Version
	private Long version;

	@Field
	private boolean active;

	@Field
	private String name;

	@Field
	private LocalDate birthDate;

	@Field
	private Gender gender;

	@Field
	private String cpf;

	@Field
	private String rg;

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String getCpf() {
		return cpf;
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

	/**
	 * Updates a binded object.
	 *
	 * @param user
	 * @return
	 */
	public IPersonalData merge(IPersonalData user) {
		BeanUtils.copyProperties(this, user, UNMERGED_PROPERTIES);
		return user;
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
