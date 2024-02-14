package com.example.demo.credentials;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserCredentials, Long> {

	UserCredentials findByContact(Long contact);

	UserCredentials findByUsername(String username);

	Boolean existsByUsername(String username);

}
