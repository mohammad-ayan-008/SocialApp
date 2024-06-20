package org.backend.Media.SocialBackend.Repository;

import org.backend.Media.SocialBackend.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByUserName(String username);
}
