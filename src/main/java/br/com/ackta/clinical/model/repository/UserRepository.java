package br.com.ackta.clinical.model.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ackta.clinical.model.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

	Optional<User> findByUsername(String username);

	Long countByMail(String mail);

}
