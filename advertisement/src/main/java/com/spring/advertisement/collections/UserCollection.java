package com.spring.advertisement.collections;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userProfiles")
public class UserCollection {

	@Id
	private String Id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private long phone;
	
	public UserCollection(){
		
	}
	
	public UserCollection(String id, String firstName, String lastName, String username, String password, String email,
			long phone) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "UserCollection [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ userName + ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
