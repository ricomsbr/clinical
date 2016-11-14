package br.com.ackta.clinical.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ackta.clinical.model.entity.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, ObjectId> {

	// Optional<Patient> findByCpf(String cpf);
	//
	// Long countByCpf(String cpf);
}
