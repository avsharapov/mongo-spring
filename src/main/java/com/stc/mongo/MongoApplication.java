package com.stc.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;

@SpringBootApplication
public class MongoApplication {
    private static final Logger logger = LoggerFactory.getLogger("MongoApplication");
    @Autowired
    MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MyMongoRepository repository) {
        return args -> {
            repository.insert(new Post("Post1", Arrays.asList("Comment 1 (post1)", "Comment 2 (post1)")));
            repository.insert(new Post("Post2", Arrays.asList("Comment 1 (post2)", "Comment 2 (post2)")));
            logger.info("FindAll!");
            logger.info("{}", repository.findAll());
            logger.info("FindByComment!");
            logger.info("{}", repository.findByCommentsContains("Comment 1 (post2)"));

            logger.info("===========MongoTemplate FindByComment============");
            Query search = new Query(Criteria.where("comments").is("Comment 1 (post2)"));
            logger.info("{}", mongoTemplate.find(search, Post.class));

        };
    }

}
