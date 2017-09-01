package com.spring.advertisement.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="actions")
public class Actions {

	@Id
	private String id;
	private String action;
	
	public Actions(){
		
	}
	
	public Actions(String id, String action) {
		super();
		this.id = id;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Actions [id=" + id + ", action=" + action + "]";
	}
	
}
