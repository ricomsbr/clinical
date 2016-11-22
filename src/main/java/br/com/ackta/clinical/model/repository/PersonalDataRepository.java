package br.com.ackta.clinical.model.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ackta.clinical.model.entity.PersonalData;

@Repository
public interface PersonalDataRepository extends MongoRepository<PersonalData, ObjectId> {
	Long countByCpf(String cpf);

	Optional<PersonalData> findByCpf(String cpf);
}
