package com.comp2009.bartering;

public class customerOrders {
	private int comboID;
	private int userID;
	private int itemID;
	private String status;
	
	public customerOrders(int comboID, int userID, int itemID, String status){
		this.comboID = comboID; this.userID = userID; this.itemID = itemID;
		this.status = status;
	}
	
	public int getComboID(){return this.comboID;}
	public int getUserID(){return this.userID;}
	public int getItemID(){return this.itemID;}
	public String getStat(){return this.status;}
	
	public void setComboID(int id) { this.comboID = id;}
	public void setUserID(int id){ this.userID = id;}
	public void setitemID(int id){this.itemID = id;}
	public void setStatus(String status){this.status = status;}
	

}
