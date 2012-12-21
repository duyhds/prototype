package com.comp2009.bartering;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class FindUser {
	private JFrame frame = new JFrame();
	private JButton back =      new JButton("      Back        ");
	private JButton getNumber = new JButton("Get Contact Number");
	
	public FindUser(String item, int UserID){
		frame.setVisible(true);frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		final int passthrough = UserID;

		int itemID = getItem(item).getitemId();
		
		ArrayList<userObject> customers = new ArrayList<userObject>();
		
		for(customerOrders x: Data.userItemTable){
			if(x.getItemID() == itemID && x.getStat().equals("Has")){
				customers.add(getUser(x.getUserID()));
			}
		}
		
		if(customers.size() == 0){
			JOptionPane.showMessageDialog(null,"Error - no users were found to have this item");
			frame.dispose();
			SwitchBoard switchboard = new SwitchBoard(passthrough);
		}
		else{
			JLabel currentuser = new JLabel("Logged in as " + getUser(passthrough).getcustForename());
			JLabel userswithitem = new JLabel("People who have this item");
			String[] customername = new String[customers.size()];

			
			int start = 0;
			for(userObject x: customers){
				customername[start] = x.getcustForename() + " " +  x.getCustSurname(); 
				start = start + 1;
 			}
			
			final JList customerlist = new JList(customername);
			
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					SwitchBoard switchboard = new SwitchBoard(passthrough);
				}
			});
			
			getNumber.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					userObject searchfor = findID(customerlist.getSelectedValue().toString());
					JOptionPane.showMessageDialog(null, searchfor.getcustForename() +"'s number is " + searchfor.getPhoneNUmber());
				}
			});
			
			constraints.gridy = 0; constraints.gridx = 0; panel.add(currentuser,constraints); 
			constraints.gridy = 1; constraints.gridx = 0; panel.add(userswithitem,constraints);
			constraints.gridy = 2; constraints.gridx = 0; panel.add(customerlist,constraints);
			constraints.gridy = 3; constraints.gridx = 0; panel.add(back,constraints);
			constraints.gridy = 4; constraints.gridx = 0; panel.add(getNumber,constraints);
			
			frame.add(panel);
		}

	}
	
	public static userObject  findID(String name){
		for(userObject x: Data.userTable){
			String fullname = x.getcustForename() + " " + x.getCustSurname();
			if(fullname.equals(name)){
				return x;
			}
		}
		return null;
	}
	
	public static userObject getUser(int x){
		for(userObject y:Data.userTable){
			if(y.getCustID() == x){
				return y;
			}
		}
		return null;
	}
	
	public static itemObject getItem(int x){
		for(itemObject y: Data.itemTable){
			if(y.getitemId() == x){
				return y;
			}
		}
		return null;
	}
	
	public static itemObject getItem(String x){
		for(itemObject y: Data.itemTable){
			if(y.getitemName().equals(x)){
				return y;
			}
		}
		return null;
	}

}
