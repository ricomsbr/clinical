package br.com.ackta.clinical.business.service;

import java.util.List;

import org.bson.types.ObjectId;

import br.com.ackta.clinical.model.entity.User;

public interface IUserService {
	User save(User user);

	List<User> findAll();

	User findById(ObjectId id);

	void delete(ObjectId id);
}
