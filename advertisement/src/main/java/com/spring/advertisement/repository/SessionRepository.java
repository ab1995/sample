package com.spring.advertisement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.advertisement.collections.UserSession;

public interface SessionRepository  extends MongoRepository<UserSession, String> {
	
	@Query(value="{_id: ?0}")
	public List<UserSession> getLoginUser(String auth_token);
	
	@Query(value="{_id : ?0}", delete = true)
	public List<UserSession> deleteSession(String auth_token);
	
	@Query(value="{userName: ?0}")
	public List<UserSession> getLoginUserByUserName(String userName);
	
	
}
