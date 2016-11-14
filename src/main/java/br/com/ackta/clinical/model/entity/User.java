package br.com.ackta.clinical.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ackta_user")
public class User implements IUser {

	private static final long serialVersionUID = -3659855708555492709L;

	@Id
	private ObjectId id;

	@Field("version")
	private Long version;

	@Field("active")
	private boolean active;

	@Field("mail")
	private String mail;

	public User() {
		super();
	}

	public User(String username, String password, String name, boolean isActive) {
		this();
		this.username = username;
		this.password = password;
		this.name = name;
		this.active = isActive;
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
	public boolean isActive() {
		return active;
	}

	@Field("name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getMail() {
		return mail;
	}

	/**
	 * Updates a binded object.
	 *
	 * @param user
	 * @return
	 */
	public User merge(User user) {
		BeanUtils.copyProperties(this, user, UNMERGED_PROPERTIES);
		return user;
	}

}
