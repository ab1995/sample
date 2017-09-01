package com.spring.advertisement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.advertisement.collections.Actions;

public interface ActionRepository extends MongoRepository<Actions, String> {

	@Query(value="{}")
	public List<Actions> getActions();
}
