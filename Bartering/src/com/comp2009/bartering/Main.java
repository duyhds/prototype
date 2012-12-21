package com.comp2009.bartering;

public class Main {


	public static void main(String[] args) {
		initliaseData();
		LoginPage x = new LoginPage();	
	}

	public static void initliaseData(){
		Data.addToItemTable(1,"Pikachu card", "Rare edition Pikachu pokemon card");
		Data.addToItemTable(2, "Charizard CArd", "Extreme rare Pokemon card");
		Data.addToItemTable(3, "Clafable", "Extremely rare shiny card");
		Data.addToItemTable(4, "Mew Two card", "Customised mew two card");
		Data.addToItemTable(5, "Mew card", "Only a few exist in the world");
		Data.addToItemTable(6, "Entai", "Only one card exists");
		
		Data.addToUserTable(1, "Rasheed", "Wahaib", "1 Fake Street", "01234");
		Data.addToUserTable(2, "EeRan", "Tan", "2 Fake Street", "12345");
		Data.addToUserTable(3, "Maryum", "Styles", "3 Fake Street", "23456" );
		Data.addToUserTable(4, "Vincent", "Nguyen", "4 Fake Street", "34567");
		Data.addToUserTable(5, "Jisang", "Choi", "5 Fake Street", "45678");
		Data.addToUserTable(6, "Michael", "Leong", "6 Fake Street", "56789");
		
		Data.addToUserItemTable(1, 1, 1, "Has");
		Data.addToUserItemTable(2, 1, 2, "Wants");
		Data.addToUserItemTable(3, 2, 2, "Has");
		Data.addToUserItemTable(4, 2, 3, "Wants");
		Data.addToUserItemTable(5, 3, 3, "Has");
		Data.addToUserItemTable(6, 3, 4, "Wants");
		Data.addToUserItemTable(7, 4, 4, "Has");
		Data.addToUserItemTable(8, 4, 5, "Wants");
		Data.addToUserItemTable(9, 5, 5, "Has");
		Data.addToUserItemTable(10, 5, 5, "Wants");
		Data.addToUserItemTable(11, 6, 6, "Has");
		Data.addToUserItemTable(12, 6, 1, "Wants");
		Data.addToUserItemTable(13, 4, 2, "Has");
		
		Data.addToUserNames("wahaib", "password1", 1);
		Data.addToUserNames("tan", "password2", 2);
		Data.addToUserNames("styles", "password3", 3);
		Data.addToUserNames("nguyen", "password4", 4);
		Data.addToUserNames("choi", "password5", 5);
		Data.addToUserNames("leong", "password6", 6);
	}
}
