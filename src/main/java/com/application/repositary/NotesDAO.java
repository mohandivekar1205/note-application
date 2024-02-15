package com.application.repositary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.model.Notes;
import com.application.model.Users;

public class NotesDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/noteapplication?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_NOTE_SQL = "INSERT INTO notes(user_id,title,content) VALUES(?,?,?);";

	private static final String SELECT_NOTE_BY_ID = "select * from notes where note_id = ?";
	private static final String SELECT_NOTE_BY_USER_ID = "select notes.*,users.* from notes join users on notes.user_id = users.id where users.username = ?";
	private static final String SELECT_NOTE_USERS = "select * from notes";
	private static final String DELETE_NOTE_SQL = "delete from notes where note_id = ?;";
	private static final String UPDATE_NOTE_SQL = "update notes set title = ?,content= ? where note_id = ?;";
	private static final String GET_ALL_DETAILS = "select notes.*,users.* from notes join users on notes.user_id = users.id where notes.note_id = ?";
	private static final String SEARCH_NOTE_SQL = "SELECT * FROM notes,users WHERE title = ?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void insertNote(Notes note) throws SQLException {
		System.out.println(INSERT_NOTE_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTE_SQL)) {
			preparedStatement.setInt(1, note.getUsers().getId());
			preparedStatement.setString(2, note.getTitle());
			preparedStatement.setString(3, note.getContent());
			System.out.println(preparedStatement);
			int status = preparedStatement.executeUpdate();
			if(status > 0) {
				System.out.print("Row insertd Successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Notes selectNotes(int id) {
		Notes notes = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				notes = new Notes(id,title,content,user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}
	
	public List<Notes> selectAllNotes() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Notes> notes = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTE_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("note_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				//notes.add(new Notes(id,title,content));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}
	
	public List<Notes> selectNotesByUserId(String username){
		
		List<Notes> notelist = new ArrayList<>();
		Users user = new Users();
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTE_BY_USER_ID);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("note_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				notelist.add(new Notes(id,title,content,user));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return notelist;
	}
	
	
	public boolean deleteNotes(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NOTE_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateNotes(Notes notes) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NOTE_SQL);) {
			preparedStatement.setString(1, notes.getTitle());
			preparedStatement.setString(2, notes.getContent());
			preparedStatement.setInt(3, notes.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}


	public ResultSet getdetailsByNoteId(int id) {
	
		ResultSet rs = null;
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DETAILS);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rs;
	}


	public List<Notes> getKeyWord(String query) {
		ResultSet rs = null;
		List<Notes> notelist = new ArrayList<>();
		Users user = new Users();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NOTE_SQL);
			preparedStatement.setString(1, query);
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("note_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				notelist.add(new Notes(id,title,content,user));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notelist;
	}	
}
