package br.com.ackta.clinical.model.entity;

import java.time.LocalDate;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "ackta_user")
@SQLDelete(sql = "UPDATE ackta_user SET active = 0 WHERE id = ? AND version = ?")
@Where(clause = "active = 1")
public class User implements IUser {

	private static final long serialVersionUID = -3659855708555492709L;

	@Id
	@SequenceGenerator(name = "sq_user", sequenceName = "sq_user")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_user")
	@Column(name = "id_user")
	private Long id;

	@Version
	@Column(name = "version", nullable = false)
	private Long version;

	@Column(name = "active", nullable = false)
	private boolean active;

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

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "birthDate", nullable = true)
	private LocalDate birthDate;

	@Column(name = "gender", nullable = true)
	private Gender gender;

	@Column(name = "mail", nullable = false, unique = true)
	private String mail;

	@Column(name = "mobile", nullable = true)
	private String mobile;

	@Transient
	private Quantity<Mass> weight;

	@Transient
	private Quantity<Length> height;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "username", nullable = false)
	private String username;

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
	public String getMail() {
		return mail;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public Quantity<Mass> getWeight() {
		return weight;
	}

	@Override
	public Quantity<Length> getHeight() {
		return height;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
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

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setWeight(Quantity<Mass> weight) {
		this.weight = weight;
	}

	public void setHeight(Quantity<Length> height) {
		this.height = height;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Updates a binded object.
	 *
	 * @param user
	 * @return
	 */
	public User merge(User user) {
		BeanUtils.copyProperties(this, user, UNMERGED_PROPERTIES);

		// user.setPassword(this.password);
		// user.setUsername(this.username);
		// user.setBirthDate(this.birthDate);
		// user.setGender(this.gender);
		// user.setHeight(this.height);
		// user.setMail(this.mail);
		// user.setMobile(this.mobile);
		// user.setWeight(this.weight);
		// user.setName(this.name);

		return user;
	}
}
