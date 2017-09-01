package com.spring.advertisement.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="categories")
public class Category {

	@Id
	String id;
	String category;
	
	public Category(String id, String category) {
		super();
		this.id = id;
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + ", getId()=" + getId() + ", getCategory()="
				+ getCategory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
