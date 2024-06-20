package org.backend.Media.SocialBackend.Repository;

import org.backend.Media.SocialBackend.entities.USER;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<USER,String> {
    USER findByUserName(String username);
}
