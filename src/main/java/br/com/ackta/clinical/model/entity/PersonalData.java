package br.com.ackta.clinical.model.entity;

//
//@Entity
//@Table(name = "personal_data")
//@SQLDelete(sql = "UPDATE personal_data SET active = 0 WHERE id = ? AND version = ?")
//@Where(clause = "active = 1")
public class PersonalData {// implements IPersonalData {

	// /**
	// *
	// */
	// private static final long serialVersionUID = -2383673733659048451L;
	//
	// @Id
	// @SequenceGenerator(name = "sq_personal_data", sequenceName =
	// "sq_personal_data")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "sq_personal_data")
	// @Column(name = "id")
	// private Long id;
	//
	// @Version
	// @Column(name = "version", nullable = false)
	// private Long version;
	//
	// @Column(name = "active", nullable = false)
	// private boolean active;
	//
	// @Column(name = "name", nullable = false)
	// private String name;
	//
	// @Column(name = "birthDate", nullable = true)
	// private LocalDate birthDate;
	//
	// @Column(name = "gender", nullable = false)
	// private Gender gender;
	//
	// @Column(name = "cpf", nullable = true)
	// private String cpf;
	//
	// @Column(name = "rg", nullable = true)
	// private String rg;
	//
	// @Column(name = "sus", nullable = true)
	// private String sus;
	//
	// // @ManyToMany()
	// // @JoinColumn(name = "responsible", nullable = true)
	// // private List<IPersonalData> responsibles;
	// //
	// @Override
	// public Long getVersion() {
	// return version;
	// }
	//
	// @Override
	// public void setVersion(Long version) {
	// this.version = version;
	// }
	//
	// @Override
	// public boolean isActive() {
	// return active;
	// }
	//
	// @Override
	// public Long getId() {
	// return id;
	// }
	//
	// @Override
	// public String getName() {
	// return name;
	// }
	//
	// @Override
	// public LocalDate getBirthDate() {
	// return birthDate;
	// }
	//
	// @Override
	// public Gender getGender() {
	// return gender;
	// }
	//
	// @Override
	// public String getCpf() {
	// return cpf;
	// }
	//
	// public void setCpf(String cpf) {
	// this.cpf = cpf;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// public void setBirthDate(LocalDate birthDate) {
	// this.birthDate = birthDate;
	// }
	//
	// public void setGender(Gender gender) {
	// this.gender = gender;
	// }
	//
	// @Override
	// public void setId(Long id) {
	// this.id = id;
	// }
	//
	// @Override
	// public String getRg() {
	// return rg;
	// }
	//
	// public void setRg(String rg) {
	// this.rg = rg;
	// }
	//
	// @Override
	// public String getSus() {
	// return sus;
	// }
	//
	// public void setSus(String sus) {
	// this.sus = sus;
	// }
	//
	// /**
	// * Updates a binded object.
	// *
	// * @param user
	// * @return
	// */
	// public PersonalData merge(PersonalData user) {
	// BeanUtils.copyProperties(this, user, UNMERGED_PROPERTIES);
	// return user;
	// }
}
