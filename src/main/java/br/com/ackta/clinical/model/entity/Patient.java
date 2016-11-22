package br.com.ackta.clinical.model.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "patient")
public class Patient implements IPatient {

	private static final long serialVersionUID = -8785925386745821405L;

	@Id
	private ObjectId id;

	@Version
	private Long version;

	@Field
	private boolean active;

	@Field
	public IPersonalData personalData;

	public Patient() {
		super();
	}

	public Patient(IPersonalData personalData) {
		this();
		this.personalData = personalData;
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

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}
}
