package br.com.ackta.clinical.controller.patient;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.com.ackta.clinical.application.TestApplication;
import br.com.ackta.clinical.business.helper.PatientTO;
import br.com.ackta.clinical.controller.ControllerTest;
import br.com.ackta.clinical.model.entity.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
@WebAppConfiguration
@Rollback
@Transactional
@ActiveProfiles("tests")
@Sql("patient.sql")
public class PatientControllerTest extends ControllerTest {
	private static final String NAME2 = "pacient22";
	private static final String NAME3 = "patient33";
	private static final String CPF2 = "23456789012";
	private static final String CPF3 = "34567890123";
	private static final LocalDate DATE2 = LocalDate.of(1975, 1, 3);
	private static final LocalDate DATE3 = LocalDate.of(1980, 3, 30);
	private static final String DEFAULT_USER = "desenv";

	private PatientTO createTO(String name, String cpf, LocalDate birthDate, Gender gender) {
		final PatientTO to = new PatientTO();
		to.setName(name);
		to.setCpf(cpf);
		to.setBirthDate(birthDate);
		to.setGender(gender);
		return to;
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertOk() throws Exception {
		final PatientTO to = createTO(NAME2, CPF2, DATE2, Gender.MALE);
		insert(to).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(NAME2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value(CPF2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.birthDate").value("1975-01-03"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender").value(Gender.MALE.name()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
	}

	@Test()
	@WithUserDetails(DEFAULT_USER)
	public void insertReapeatedCpf() throws Exception {
		final PatientTO to = createTO(NAME2, "11122233344", DATE2, Gender.MALE);
		insert(to).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("patientHelper.patient.alreadyExists"))
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertNullName() throws Exception {
		final PatientTO to = createTO(null, CPF3, DATE3, Gender.MALE);
		insert(to).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	@WithUserDetails(DEFAULT_USER)
	public void insertNullCpf() throws Exception {
		final PatientTO to1 = createTO(NAME3, null, DATE3, Gender.MALE);
		insert(to1).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public ResultActions insert(final PatientTO to) throws Exception, IOException {
		return this.mockMvc.perform(
				MockMvcRequestBuilders.post("/patient").contentType(MediaType.APPLICATION_JSON).content(json(to)));
	}
}
