package com.application.model;

public class Notes {
	
	private int Id;
	private String Title;
	private String Content;
	private Users users;
	
	public Notes() {}

	

	public Notes(int id, String title, String content, Users users) {
		super();
		Id = id;
		Title = title;
		Content = content;
		this.users = users;
	}
	
	public Notes( String title, String content, Users users) {
		super();
		Title = title;
		Content = content;
		this.users = users;
	}



	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getContent() {
		return Content;
	}



	public void setContent(String content) {
		Content = content;
	}



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}


	
}
