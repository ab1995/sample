package com.spring.advertisement.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.advertisement.collections.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

	@Query(value="{}")
	public List<Category> getCategories();
	
}
