package com.comp2009.bartering;

public class userObject {
	private int custID;
	private String custForeName;
	private String custSurName;
	private String userAddress;
	private String phoneNumber;
	
	public userObject(int custID, String custForeName, String custSurName, String userAddress,
			String phoneNumber){
		this.custID = custID; this.custForeName = custForeName; this.custSurName = custSurName;
		this.userAddress = userAddress; this.phoneNumber = phoneNumber;
	}
	
	public int getCustID(){ return this.custID;}
	public String getcustForename() {return this.custForeName;}
	public String getCustSurname(){ return this.custSurName;}
	public String getUserAddress() { return this.userAddress;}
	public String getPhoneNUmber() { return this.phoneNumber;}
	
	public void setCustID(int custID) { this.custID = custID;}
	public void setForeName(String forename) {this.custForeName = forename;}
	public void setSurname (String surname) { this.custSurName = surname;}
	public void setUserAddress(String address) {this.userAddress = address;}
	public void setPhoneNumber(String phoneNUmber){ this.phoneNumber = phoneNUmber;}
	

}
