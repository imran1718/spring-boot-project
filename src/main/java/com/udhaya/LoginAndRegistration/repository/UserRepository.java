package com.udhaya.LoginAndRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.udhaya.LoginAndRegistration.Models.*;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
