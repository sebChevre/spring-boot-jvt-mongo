package ch.sebooom.jwt.repository;

import ch.sebooom.jwt.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);
}
