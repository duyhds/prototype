package com.comp2009.bartering;

public class itemObject {
	private int itemID;
	private String itemName;
	private String description;
	
	public itemObject(int itemID, String itemName, String description){
		this.itemID  = itemID; 
		this.itemName = itemName;
		this.description = description;
	}
	
	public int getitemId(){ return this.itemID;}
	public String getitemName() { return this.itemName;}
	public String getDescription() { return this.description;}
	
	public void setitemID(int itemID){this.itemID = itemID;}
	public void setitemName(String description){ this.itemName = description;}
	public void setDescription(String description){ this.description = description;}
	
	
	
	

}
