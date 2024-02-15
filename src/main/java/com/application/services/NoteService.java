package com.application.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.model.Notes;
import com.application.model.Users;
import com.application.repositary.NotesDAO;
import com.application.repositary.UsersDAO;

public class NoteService {

	
		NotesDAO noteDAO = new NotesDAO();
		UsersDAO userDAO = new UsersDAO();
		Notes notes = new Notes();
	
	public void save(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		// TODO Auto-generated method stub
		
		notes.setTitle(request.getParameter("title"));
		notes.setContent(request.getParameter("content"));
		notes.setUsers(userDAO.selectUser(username));
		noteDAO.insertNote(notes);
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    //dispatcher.forward(request, response);
	}

	public List<Notes> getNoteById(String username) {
		// TODO Auto-generated method stub
		List<Notes> list = new ArrayList<>();
		list = noteDAO.selectNotesByUserId(username);
		return list;
	}

	public void getAllNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		List<Notes> notelist = new ArrayList(); 
		notelist = getNoteById(username);
		System.out.print(notelist);
		request.setAttribute("list",notelist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
		
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		noteDAO.deleteNotes(id);
		System.out.print("delete method call...");
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		Notes notes = new Notes();
		ResultSet no;
		no = noteDAO.getdetailsByNoteId(Integer.parseInt(request.getParameter("id")));
		
		notes.setId(Integer.parseInt(request.getParameter("id")));
		notes.setTitle(request.getParameter("updatedTitle"));
		notes.setContent(request.getParameter("updatesContent"));
		
		Users user = new Users();
		
		while(no.next()) {
			user.setId(no.getInt("user_id"));
			user.setUsername(no.getString("username"));
			user.setPassword(no.getString("password"));
			user.setFirstName(no.getString("first_name"));
			user.setLastName(no.getString("last_name"));
			notes.setUsers(user);
		}
		boolean status = noteDAO.updateNotes(notes);
		System.out.print(status);
		if(status==true)
				System.out.print("Note Updates Successfully");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    //dispatcher.forward(request, response);
	}

	public void SearchOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = request.getParameter("search");
		System.out.print(query);
		List<Notes> list = (List<Notes>) noteDAO.getKeyWord(query);
		request.setAttribute("list",list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
	}

}
