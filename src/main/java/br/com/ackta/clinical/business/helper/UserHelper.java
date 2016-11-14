package br.com.ackta.clinical.business.helper;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ackta.clinical.business.service.IUserService;
import br.com.ackta.clinical.business.service.exception.EntityNotFoundException;
import br.com.ackta.clinical.business.service.exception.EntitytAlreadyExistsException;
import br.com.ackta.clinical.controller.util.ControllerException;
import br.com.ackta.clinical.model.entity.User;

@Service
public class UserHelper {

	private final IUserService userService;

	@Autowired
	public UserHelper(IUserService service) {
		this.userService = service;
	}

	public UserTO save(UserTO userTO) {
		userTO.getId();
		User obj = userTO.getEntity();
		UserTO result = null;
		try {
			User savedElement = userService.save(obj);
			result = new UserTO(savedElement);
		} catch (EntitytAlreadyExistsException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return result;
	}

	public ResponseEntity<Void> delete(ObjectId id) {
		try {
			userService.delete(id);
		} catch (final EntityNotFoundException ex) {
			throw new ControllerException(HttpStatus.BAD_REQUEST, this.getClass(), ex);
		}
		return ResponseEntity.ok().build();
	}
}
