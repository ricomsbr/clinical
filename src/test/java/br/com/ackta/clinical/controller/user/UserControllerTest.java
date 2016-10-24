package br.com.ackta.clinical.controller.user;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.application.TestApplication;
import br.com.ackta.clinical.business.helper.UserTO;
import br.com.ackta.clinical.controller.ControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
@Rollback
@Transactional
@ActiveProfiles("tests")
public class UserControllerTest extends ControllerTest {
	private static final String USERNAME2 = "username2";
	private static final String USERNAME4 = "username4";
	private static final String MAIL2 = "mail2@ackta.com.br";
	private static final String MAIL4 = "mail4@ackta.com.br";
	private static final String NAME4 = "Name4";
	private static final String PASSWORD4 = "password4";
	private static final String DEFAULT_USER = "DEVELOPER";

	private UserTO createTO(String name, String password, String username, String email) {
		final UserTO to = new UserTO();
		to.setName(name);
		to.setPassword(password);
		to.setUsername(username);
		to.setMail(email);
		return to;
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertOk() throws Exception {
		final UserTO to = createTO(NAME4, PASSWORD4, USERNAME4, MAIL4);
		insert(to).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username").value(USERNAME4))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password").value(PASSWORD4))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(NAME4))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
	}

	@Test()
	@WithUserDetails(DEFAULT_USER)
	public void insertReapeatedUsername() throws Exception {
		final UserTO to = createTO(NAME4, PASSWORD4, USERNAME2, MAIL4);
		insert(to).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test()
	@WithUserDetails(DEFAULT_USER)
	public void insertReapeatedMail() throws Exception {
		final UserTO to = createTO(NAME4, PASSWORD4, USERNAME4, MAIL2);
		insert(to).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("userController.user.alreadyExists"));
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertNullUsername() throws Exception {
		final UserTO to = createTO(NAME4, PASSWORD4, null, MAIL4);
		insert(to).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertNullMail() throws Exception {
		final UserTO to = createTO(NAME4, PASSWORD4, USERNAME4, null);
		insert(to).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	public ResultActions insert(final UserTO to) throws Exception, IOException {
		return this.mockMvc.perform(
				MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON).content(json(to)));
	}
}
