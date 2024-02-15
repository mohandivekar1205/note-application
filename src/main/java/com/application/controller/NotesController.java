package com.application.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.model.Notes;
import com.application.services.NoteService;
import com.google.gson.Gson;

/**
 * Servlet implementation class NotesController
 */
@WebServlet("/noteController")
public class NotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    NoteService noteService = new NoteService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		noteService.getAllNotes(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation  = request.getParameter("action");
		
		System.out.print(operation + "operation is selected");
		
		if(operation.equals("insert")) {
			try {
				noteService.save(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(operation.equals("edit")){
			
			try {
				noteService.update(request,response);
				System.out.print("edit block executed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(operation.equals("delete")){
			try {
				noteService.delete(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(operation.equals("search")){
			noteService.SearchOperation(request,response);	
		}
		doGet(request, response);
	}
}
