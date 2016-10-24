/**
 *
 */
package br.com.ackta.clinical.business.helper;

import java.time.LocalDate;
import java.util.Objects;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ackta.clinical.model.entity.Gender;
import br.com.ackta.clinical.model.entity.User;

public class UserTO {

	private Long id;

	@NotNull(message = "{active.null}")
	private boolean active = true;

	private Long version;

	@NotNull(message = "{username.null}")
	private String username;

	@NotNull(message = "{name.null}")
	private String name;

	@NotNull(message = "{password.null}")
	private String password;

	@NotNull(message = "{mail.null}")
	private String mail;

	private LocalDate birthDate;

	private Gender gender;

	private Quantity<Length> height;

	private String mobile;

	private Quantity<Mass> weight;

	public UserTO() {
		super();
	}

	public UserTO(User user1) {
		this();
		if (Objects.nonNull(user1)) {
			BeanUtils.copyProperties(user1, this);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Quantity<Length> getHeight() {
		return height;
	}

	public void setHeight(Quantity<Length> height) {
		this.height = height;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Quantity<Mass> getWeight() {
		return weight;
	}

	public void setWeight(Quantity<Mass> weight) {
		this.weight = weight;
	}

	/**
	 * @return
	 */
	@JsonIgnore
	public User getEntity() {
		final User result = new User();
		BeanUtils.copyProperties(this, result);
		return result;
	}

}