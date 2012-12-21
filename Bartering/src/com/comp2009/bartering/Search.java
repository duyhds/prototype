package com.comp2009.bartering;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Search {
	JFrame frame = new JFrame();
	JButton back = new JButton("Back");
	
	
	public Search(int userID, String criteria){
		final int passthrough = userID;
		criteria = criteria.toLowerCase().replaceAll(" ", "");
		
		frame.setVisible(true); frame.setSize(700,700); frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout()); 
		panel.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		ArrayList<itemObject> byName = new ArrayList<itemObject>();

		
		for(itemObject x: Data.itemTable){
			String temp = x.getitemName().toLowerCase().replaceAll(" ", "");
			boolean y = temp.contains(criteria);
			if(y == true){
				byName.add(x);
			}
		}

		
		JLabel user = new JLabel("Logged in as " + getUser(userID).getcustForename());
		JLabel results = new JLabel("Search Results");

		
		if(byName.size() == 0){
			JOptionPane.showMessageDialog(null, "There are no results");
			frame.dispose();
			SwitchBoard switchboard = new SwitchBoard(userID);
		}
		else{
			String[] itemnames = new String[byName.size()];
			String[] itemdescriptions = new String[byName.size()];
			
			int start = 0;
			for(itemObject x: byName){
				itemnames[start] = x.getitemName();
				itemdescriptions[start] = x.getDescription();
				start = start + 1;
			}

			JList itemnamelist = new JList(itemnames);
			JList itemdescriptionlist = new JList(itemdescriptions);
			
			back.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					SwitchBoard swicthboard = new SwitchBoard(passthrough);
				}
			});
			
			constraints.gridy = 0; constraints.gridx = 1; panel.add(user,constraints);
			constraints.gridy = 1; constraints.gridx = 1; panel.add(results,constraints);
			constraints.gridy = 2; constraints.gridx = 0; panel.add(itemnamelist,constraints);
			constraints.gridy = 2; constraints.gridx = 2; panel.add(itemdescriptionlist,constraints);
			constraints.gridy = 3; constraints.gridx = 1; panel.add(back,constraints);
			frame.add(panel);
			
		}
	}
	
	public static userObject getUser(int x){
		for(userObject y:Data.userTable){
			if(y.getCustID() == x){
				return y;
			}
		}
		return null;
	}
}
