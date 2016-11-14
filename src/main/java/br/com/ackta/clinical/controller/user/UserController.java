/**
 *
 */
package br.com.ackta.clinical.controller.user;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ackta.clinical.business.helper.UserHelper;
import br.com.ackta.clinical.business.helper.UserTO;

@RestController(value = "userController")
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
// @Validated
public class UserController {

	private final UserHelper helper;

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserHelper helper1) {
		this.helper = helper1;
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserTO save(@RequestBody @Valid UserTO userTO) {
		LOGGER.info("Method save initialized. Set size: [{}] ", new Object[] { userTO });
		UserTO result = null;
		result = helper.save(userTO);
		LOGGER.debug("[{}] itens saved as User.", result);
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
		LOGGER.info("Method delete initialized. Remove user id ", new Object[] { id });
		ResponseEntity<Void> result = helper.delete(id);
		return result;
	}
}
