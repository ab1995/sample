package com.spring.advertisement.repository;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.spring.advertisement.collections.UserCollection;

public interface UserRepository extends MongoRepository<UserCollection, String> {
	
	@Query(value="{userName: ?0}")
	public List<UserCollection> getAuthorisedUser(String userName, String password);
	
}
