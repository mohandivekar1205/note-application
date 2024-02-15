package com.application.services;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.application.model.Users;
import com.application.repositary.UsersDAO;

public class LoginService  extends HttpServlet {
	
	UsersDAO user = new UsersDAO();

	Users UsersObj;
	
	public boolean login(String username, String password) throws SQLException {
		
	
		try {
			UsersObj = user.selectUser(username);
			if(username.equals(UsersObj.getUsername()) && 
					password.equals(UsersObj.getPassword())) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
}
