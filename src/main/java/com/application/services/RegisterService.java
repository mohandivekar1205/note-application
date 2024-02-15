package com.application.services;

import java.sql.SQLException;

import com.application.model.Users;
import com.application.repositary.UsersDAO;

public class RegisterService {

	
	UsersDAO repo = new UsersDAO();
	
	
	public void register(String username, String password, String firstname, String lastname) throws SQLException {
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		repo.insertUser(user);	
	}
	
	
	

}
