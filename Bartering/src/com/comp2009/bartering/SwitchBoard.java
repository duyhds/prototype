package com.comp2009.bartering;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SwitchBoard {
	JFrame frame = new JFrame();
	JTextField search = new JTextField(10);
	JButton pressearch = new JButton("Search");
	JButton finduser = new JButton("    Find User ");
	JButton viewall = new  JButton("View All Items");
	JButton logout = new   JButton("    Logout    ");
	
	public SwitchBoard(int UserID){
		final int passthrough = UserID;
		frame.setVisible(true); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700); frame.setBackground(Color.WHITE);
		JPanel panel = new JPanel(new GridBagLayout()); panel.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel searchlabel = new JLabel("Search: ");
		JLabel wantedlabel = new JLabel("Wanted Items: ");
		JLabel tradingLabel = new JLabel ("Trading Items: ");
		JLabel itemnamelabel = new JLabel("Name");
		JLabel itemdescriptionLabel = new JLabel ("Description");
		JLabel welcome = new JLabel("Welcome " + getUser(UserID).getcustForename());
		
		ArrayList<Integer> itemIDHave = new ArrayList<Integer>();
		ArrayList<Integer> itemIDWant = new ArrayList<Integer>();
		
		for(customerOrders x: Data.userItemTable){
			if(x.getUserID() == UserID){
				if(x.getStat().equals("Has")){
					itemIDHave.add(x.getItemID());
				}
				if(x.getStat().equals("Wants")){
					itemIDWant.add(x.getItemID());
				}
			}
		}
		
		
		String[] test = new String[itemIDHave.size()];
		String[] test2 = new String[itemIDWant.size()] ;
		
		String[] testdescription = new String[itemIDHave.size()];
		String[] test2description = new String[itemIDWant.size()];
		
		int start = 0;
		for(Integer temp: itemIDHave){
			test[start] = getItem(temp).getitemName();
			testdescription[start] = getItem(temp).getDescription();
			start = start + 1;
		}
		
		start = 0;
		for(Integer temp: itemIDWant){
			test2[start] = getItem(temp).getitemName();
			test2description[start] = getItem(temp).getDescription();
			start = start + 1;
		}
		
		JList have = new JList(test);
		final JList wanted = new JList(test2);
		JList havedescription = new JList(testdescription);
		JList wantdescription = new JList(test2description);
		
		viewall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				All a = new All(passthrough);
				frame.dispose();
				System.gc();
			}
		});
		
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				LoginPage x = new LoginPage();
				System.gc();
			}
		});
		
		pressearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String criteria = search.getText();
				frame.dispose();
				Search search = new Search(passthrough,criteria);
			}
		});
		
		finduser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String criteria = wanted.getSelectedValue().toString();
				if(criteria.equals(null)){
					JOptionPane.showMessageDialog(null, "You Must select an item name in your wanted section");
				}
				else{
					frame.dispose();
					FindUser finduser = new FindUser(criteria,passthrough);
				}
			}
		});
		
		constraints.gridy = 0; constraints.gridx = 1; panel.add(welcome,constraints);
		constraints.gridy = 1; constraints.gridx = 0; panel.add(searchlabel,constraints);
		constraints.gridy = 1; constraints.gridx = 1; panel.add(search,constraints);
		constraints.gridy = 1; constraints.gridx = 2; panel.add(pressearch,constraints);
		constraints.gridy = 2; constraints.gridx = 1; panel.add(itemnamelabel,constraints);
		constraints.gridy = 2; constraints.gridx = 2; panel.add(itemdescriptionLabel,constraints);
		constraints.gridy = 3; constraints.gridx = 0; panel.add(tradingLabel,constraints);
		constraints.gridy = 4; constraints.gridx = 1; panel.add(have,constraints);
		constraints.gridy = 4; constraints.gridx = 2;; panel.add(havedescription,constraints);
		constraints.gridy = 5; constraints.gridx = 0; panel.add(wantedlabel,constraints);
		constraints.gridy = 6; constraints.gridx = 1; panel.add(wanted,constraints);
		constraints.gridy = 6; constraints.gridx = 2; panel.add(wantdescription,constraints);
		constraints.gridy = 7; constraints.gridx = 0; panel.add(viewall,constraints);
		constraints.gridy = 9; constraints.gridx = 0; panel.add(finduser,constraints);
		constraints.gridy = 10; constraints.gridx = 0; panel.add(logout,constraints);
		
		
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
	
	public static itemObject getItem(int x){
		for(itemObject y: Data.itemTable){
			if(y.getitemId() == x){
				return y;
			}
		}
		return null;
	}
	
}
