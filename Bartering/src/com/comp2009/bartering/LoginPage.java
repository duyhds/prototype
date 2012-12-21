package com.comp2009.bartering;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPage {
	JFrame frame = new JFrame();
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(10);
	JButton button = new JButton("Login");
	
	public LoginPage(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700,700);
		frame.setTitle("Prototype Bartering system");
		frame.setBackground(Color.WHITE);
		
		JLabel loginlabel = new JLabel("Login to the System");
		JLabel userlabel = new JLabel("Username: ");
		JLabel passwordlabel = new JLabel("Password: ");
		
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints constrainst = new GridBagConstraints();
		panel.setBackground(Color.WHITE);
		
		String[] itemnames = new String[3];
		String[] itemdescriptions = new String[3];
		
		int start = 0;
		for(start = 0; start < 3; start++){
			itemnames[start] = Data.itemTable.get(start).getitemName(); 
			itemdescriptions[start] = Data.itemTable.get(start).getDescription();
		}
		
		JList itemnameslist = new JList(itemnames);
		JList itemdescriptionslist = new JList(itemdescriptions);
		JLabel featured = new JLabel("Featured items");
		JLabel namelabel = new JLabel("Item Name");
		JLabel descriptionlabel = new JLabel("Description");
		
		
		constrainst.gridy = 0; constrainst.gridx = 2; panel.add(loginlabel, constrainst);
		constrainst.gridy = 1; constrainst.gridx = 0; panel.add(userlabel, constrainst);
		constrainst.gridy = 1; constrainst.gridx = 1; panel.add(username, constrainst);
		constrainst.gridy = 1; constrainst.gridx = 2; panel.add(passwordlabel,constrainst);
		constrainst.gridy = 1; constrainst.gridx = 3; panel.add(password,constrainst);
		constrainst.gridy = 1; constrainst.gridx = 4; panel.add(button,constrainst);
		constrainst.gridy = 2; constrainst.gridx = 1; panel.add(featured,constrainst);
		constrainst.gridy = 3; constrainst.gridx = 0; panel.add(namelabel,constrainst);
		constrainst.gridy = 3; constrainst.gridx = 2; panel.add(descriptionlabel,constrainst);
		constrainst.gridy = 4; constrainst.gridx = 0; panel.add(itemnameslist,constrainst);
		constrainst.gridy = 4; constrainst.gridx = 2; panel.add(itemdescriptionslist,constrainst);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String x = username.getText();
				String y = new String (password.getPassword());
				if(x.equals("") || password.equals("")){
					JOptionPane.showMessageDialog(null,"No blank fields");
				}
				else{
					int verification = test(x,y);
					if(verification == 99999){
						JOptionPane.showMessageDialog(null,"Incorrect information");
						username.setText(""); password.setText("");
					}
					else{
						userObject liko = getUser(verification);
						SwitchBoard switchboard = new SwitchBoard(liko.getCustID());
						frame.dispose(); System.gc();
					}
				}
				
			}
		});
		
		
		frame.add(panel);
	
	}
	
	public static int test(String username, String password){
		for(Users x: Data.usernamepasswordTable){
			if(x.getUsername().equals(username)){
				if(x.getPassword().equals(password)){
					return x.userID;
				}
			}
		}
		return 99999;
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
