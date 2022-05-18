package com.boots.repository;

import com.boots.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

//public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
//}

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}

