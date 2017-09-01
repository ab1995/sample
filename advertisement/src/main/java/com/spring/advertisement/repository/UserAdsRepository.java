package com.spring.advertisement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.advertisement.collections.UserAds;

public interface UserAdsRepository extends MongoRepository<UserAds, String> {
	
	@Query(value="{userName: ?0}")
	public List<UserAds> getAuthorisedUser(String userName);
	
}
