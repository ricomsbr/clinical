package br.com.ackta.clinical.business.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.business.service.exception.EntitytAlreadyExistsException;
import br.com.ackta.clinical.model.entity.User;
import br.com.ackta.clinical.model.repository.UserRepository;

@Service
public class UserService implements IUserService {

	private UserRepository repository;

	public UserService(UserRepository rep) {
		repository = rep;
	}

	@Override
	@Transactional
	public User save(User newData) {
		checkConsistency(newData);
		final ObjectId id = newData.getId();
		User toSave = null;
		if (Objects.nonNull(id)) { // Update
			toSave = findById(id);
			toSave = toSave.merge(newData);
		} else { // Insert
			toSave = newData;
		}
		return repository.save(toSave);
	}

	private void checkConsistency(User user) {
		Long countByMail = repository.countByMail(user.getMail());
		if (countByMail > 0) {
			throw new EntitytAlreadyExistsException(User.class);
		}
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(ObjectId id) {
		return Optional.of(repository.findOne(id)).orElseThrow(() -> new EntityNotFoundException(User.class));
	}

	@Override
	public void delete(ObjectId id) {
		User user = findById(id);
		repository.delete(user.getId());
	}

	public User findByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException(User.class));
	}

}
