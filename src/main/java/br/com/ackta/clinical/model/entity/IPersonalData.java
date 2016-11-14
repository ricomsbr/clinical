package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

public interface IPersonalData extends IPersistable {
	static final String[] UNMERGED_PROPERTIES = { "id", "active", "version" };

	String getName();

	LocalDate getBirthDate();

	Gender getGender();

	String getCpf();

	String getRg();

	String getSus();
	//
	// IAddress getAddress();
	//
	// List<IPhone> getPhones();
	//
	// MaritalState getMaritalState();
	//
	// Integer getSonQty();
	//
	// String getMail();
}
