package com.stc.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyMongoRepository extends MongoRepository<Post, String> {
    List<Post> findByCommentsContains(String comment);

}
