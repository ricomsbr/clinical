package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

public interface IUser extends IPersistable {
	static final String[] UNMERGED_PROPERTIES = { "id", "active", "version" };

	String getName();

	LocalDate getBirthDate();

	Gender getGender();

	String getMail();

	String getMobile();

	Quantity<Mass> getWeight();

	Quantity<Length> getHeight();
}
