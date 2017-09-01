package com.spring.advertisement.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user_session")
public class UserSession {

	@Id
	private String id;
	private String userName;
	
	public UserSession(){
		
	}
	public UserSession(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserSession [id=" + id + ", userName=" + userName + "]";
	}
}
