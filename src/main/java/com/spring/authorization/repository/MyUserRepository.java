package com.spring.authorization.repository;

import com.spring.authorization.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends MongoRepository<User, ObjectId> {

    public User findByUsername(String username);
}
