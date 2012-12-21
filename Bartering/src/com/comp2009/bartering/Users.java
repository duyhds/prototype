package com.comp2009.bartering;

public class Users {
	public String username;
	public String password;
	public int userID;
	
	public Users(String username, String password, int userID){
		this.username = username; this.password = password;
		this.userID = userID;
	}
	
	public void setUsername(String username){this.username = username;}
	public void setPassword(String password){this.password = password;}
	public void setUserID(int ID){ this.userID = ID;}

	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public int getUserID() {return userID;}
	
	
}
