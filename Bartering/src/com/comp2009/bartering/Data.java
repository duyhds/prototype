package com.comp2009.bartering;

import java.util.LinkedList;

public class Data {
	public static LinkedList<itemObject> itemTable = new LinkedList<itemObject>();
	public static LinkedList<userObject> userTable = new LinkedList<userObject>();
	public static LinkedList<customerOrders> userItemTable = new LinkedList<customerOrders>();
	public static LinkedList<Users> usernamepasswordTable = new LinkedList<Users>();
	
	public static void addToItemTable(int itemID, String itemName, String description){
		itemObject temp = new itemObject(itemID,itemName,description);
		itemTable.add(temp);
	}
	
	public static void addToUserTable(int custID, String custForeName, String custSurName, String userAddress,
			String phoneNumber){
		userObject x = new userObject(custID,custForeName,custSurName,userAddress,phoneNumber);
		userTable.add(x);
	}
	
	public static void addToUserItemTable(int comboID, int userID, int itemID, String status){
		customerOrders temp = new customerOrders(comboID,userID,itemID,status);
		userItemTable.add(temp);
	}
	
	public static void addToUserNames (String username, String password, int userID){
		Users temp = new Users(username,password,userID);
		usernamepasswordTable.add(temp);
	}
	
	
	
	
	
}
