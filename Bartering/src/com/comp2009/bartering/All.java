package com.comp2009.bartering;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class All {
	JFrame frame = new JFrame();
	JButton back = new JButton("Back");
	
	public All(int userID){
		final int passthrough = userID;
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.setTitle("Prototype Bartering system");
		frame.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constrainst = new GridBagConstraints();
		panel.setBackground(Color.WHITE);
		
		String[] itemnames = new String[Data.itemTable.size()];
		String[] itemdescriptions = new String[Data.itemTable.size()];
		
		int start = 0;
		for(start = 0; start < Data.itemTable.size(); start++){
			itemnames[start] = Data.itemTable.get(start).getitemName();
			itemdescriptions[start] = Data.itemTable.get(start).getDescription();
		}
		
		JList names = new JList(itemnames);
		JList descriptions = new JList(itemdescriptions);
		
		JLabel nameLabel = new JLabel("Item name");
		JLabel descriptionlabel = new JLabel("Description");
		JLabel viewall = new JLabel("View all items");
		JLabel log = new JLabel("Logged in as " + getUser(userID).getcustForename());
		
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SwitchBoard login = new SwitchBoard(passthrough);
				frame.dispose();
				System.gc();
			}
		});
		
		constrainst.gridy = 0; constrainst.gridx = 1; panel.add(nameLabel,constrainst);
		constrainst.gridy = 0; constrainst.gridx = 1; panel.add(log,constrainst);
		constrainst.gridy = 1; constrainst.gridx = 0; panel.add(nameLabel,constrainst);
		constrainst.gridy = 1; constrainst.gridx = 2; panel.add(descriptionlabel,constrainst);
		constrainst.gridy = 2; constrainst.gridx = 0; panel.add(names,constrainst);
		constrainst.gridy = 2; constrainst.gridx = 2; panel.add(descriptions,constrainst);
		constrainst.gridy = 3; constrainst.gridx = 1; panel.add(back,constrainst);
		frame.add(panel);		
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
