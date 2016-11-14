package br.com.ackta.clinical.model.entity;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Entity
//@Table(name = "patient")
//@SQLDelete(sql = "UPDATE patient SET active = 0 WHERE id = ? AND version = ?")
//@Where(clause = "active = 1")
@Document(collection = "patient")
public class Patient implements IPatient {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	private static final long serialVersionUID = -8785925386745821405L;

	// @Id
	// @SequenceGenerator(name = "sq_patient", sequenceName = "sq_patient")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "sq_patient")
	// @Column(name = "id")
	@Id
	private ObjectId id;

	// @Version
	// @Column(name = "version", nullable = false)
	@Field
	private Long version;

	// @Column(name = "active", nullable = false)
	@Field
	private boolean active;

	// TODO
	// @Column(name = "name", nullable = false)
	@Field
	private String name;

	// TODO
	// @Column(name = "cpf", nullable = true)
	@Field
	private String cpf;

	// TODO
	// @Column(name = "gender", nullable = false)
	@Field()
	private Gender gender;

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
	public ObjectId getId() {
		return id;
	}

	@Override
	public void setId(ObjectId id) {
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
