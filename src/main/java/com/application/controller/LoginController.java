package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.services.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			LoginService loginService = new LoginService();
			
			HttpSession session = request.getSession();
						
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean status = loginService.login(username,password);
			if(status) {
				System.out.println("Login Successfully");
				
		        session.setAttribute("username", username);
				
		        response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("Login.jsp");
				System.out.println("Login Failed");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}	

}
