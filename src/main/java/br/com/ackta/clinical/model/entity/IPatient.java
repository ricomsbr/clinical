package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

public interface IPatient extends IPersistable {
	static final String[] UNMERGED_PROPERTIES = { "id", "active", "version" };

	String getName();

	LocalDate getBirthDate();

	Gender getGender();

	String getCpf();
	// String getMail();
	//
	// Address getAddress();
	//
	// List<Phone> getPhones();
	//
	// Quantity<Mass> getWeight();
	//
	// Quantity<Length> getHeight();

}
