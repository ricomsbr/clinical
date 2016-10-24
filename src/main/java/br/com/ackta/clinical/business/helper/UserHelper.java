package br.com.ackta.clinical.business.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ackta.clinical.business.service.IUserService;
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
		return new UserTO(userService.save(obj));
	}

	public void delete(Long id) {
		userService.delete(id);
	}
}
