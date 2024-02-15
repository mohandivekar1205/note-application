package com.application.model;

public class Users {
	
	private int Id;
	private String FirstName;
	private String LastName;
	private String Username;
	private String Password;
	
	public Users() {
		
	}

	public Users(int id, String firstName, String lastName, String username, String password) {
		super();
		Id = id;
		FirstName = firstName;
		LastName = lastName;
		Username = username;
		Password = password;
	}
	
	public Users(String firstName, String lastName, String username, String password) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Username = username;
		Password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
}
