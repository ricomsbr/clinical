/**
 *
 */
package br.com.ackta.clinical.business.helper;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ackta.clinical.model.entity.IUser;
import br.com.ackta.clinical.model.entity.User;

public class UserTO implements IUser {

	private static final long serialVersionUID = -6681492623640858693L;

	private ObjectId id;

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

	public UserTO() {
		super();
	}

	public UserTO(User user1) {
		this();
		if (Objects.nonNull(user1)) {
			BeanUtils.copyProperties(user1, this);
		}
	}

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	@Override
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Long getVersion() {
		return version;
	}

	@Override
	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
