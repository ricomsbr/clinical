package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "patient")
@SQLDelete(sql = "UPDATE patient SET active = 0 WHERE id = ? AND version = ?")
@Where(clause = "active = 1")
public class Patient implements IPatient {

	private static final long serialVersionUID = -8785925386745821405L;

	@Id
	@SequenceGenerator(name = "sq_patient", sequenceName = "sq_patient")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_patient")
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birthDate", nullable = true)
	private LocalDate birthDate;

	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "cpf", nullable = true)
	private String cpf;

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Updates a binded object.
	 *
	 * @param user
	 * @return
	 */
	public Patient merge(Patient user) {
		BeanUtils.copyProperties(this, user, UNMERGED_PROPERTIES);
		return user;
	}
}
