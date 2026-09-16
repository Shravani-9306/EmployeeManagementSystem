package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
	import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
	import java.awt.TextField;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Date;

import com.EmployeeManagementSystem.controller.EmployeeMgtController;

	public class EmployeeRegistration extends Applet implements ActionListener {
	    Label l1, l2, l3, l4, l5, l6, l7,l8,l9;
	    TextField t1, t2, t3, t4, t5, t6,t7,t8;
	    
	    Button b1,b2;

	    public void init() {
	        l1 = new Label("Employee First Name");
	        l2 = new Label("Employee Last Name");
	        l3 = new Label("Email");
	        l4 = new Label("Password");
	        l5 = new Label("Confirm Password");
	        l6 = new Label("Mobile");
	        l7 = new Label("Department ID");
	        l8 = new Label("Joining Date");
	        l9 = new Label("");

	        t1 = new TextField(20);
	        t2 = new TextField(20);
	        t3 = new TextField(20);
	        t4 = new TextField(20);
	        t5 = new TextField(20);
	        t6 = new TextField(20);
	        t7=new TextField(20);
	        t8=new TextField(20);

	        t4.setEchoChar('*');
	        t5.setEchoChar('*');

	        b1 = new Button("Register");
	        b2 = new Button("Go to Login");

	        add(l1);
	        add(t1);
	        add(l2);
	        add(t2);
	        add(l3);
	        add(t3);
	        add(l4);
	        add(t4);
	        add(l5);
	        add(t5);
	        add(l6);
	        add(t6);
	        add(l7);
	        add(t7);
	        add(l8);
	        add(t8);
	        add(l9);

	        b1.addActionListener(this);
	        add(b1);
	        b2.addActionListener(this);
	        add(b2);
	    }

	    public void actionPerformed(ActionEvent e) {

	        if (e.getSource() == b1) {

	            String fname = t1.getText();
	            String lname = t2.getText();
	            String email = t3.getText();
	            String password = t4.getText();
	            String confirmPassword = t5.getText();
	            String mobile = t6.getText();
	            String deptId = t7.getText();
	            String joindate = t8.getText(); 
	            
	            if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || password.isEmpty() ||
	            		   confirmPassword.isEmpty() || mobile.isEmpty() ||
	            		   deptId.isEmpty() || joindate.isEmpty()) {
	            		    l9.setText("All fields are required");
	            		    return;
	            		}
	           try {
	        	   int dept = Integer.parseInt(deptId);
	        	   Date date = Date.valueOf(joindate);
	            EmployeeMgtController emc=new EmployeeMgtController();
	            boolean reg= emc.empreg(fname,lname,email,password,confirmPassword,mobile,dept,date);
		       	if(reg==true) {
					l9.setText("Welcome "+fname);
				}
				else {
					l9.setText("Please try again");
				}
	           }
	           catch(Exception re) {
	        	    re.printStackTrace();
	        	    l9.setText("Something went wrong");
	        	}
	            
	        }
	        if(e.getSource() == b2) {

	            Frame f = new Frame("Employee Login");

	            Login el = new Login();
	            el.loginFrame = f;

	            f.add(el);
	           

	            el.init();

	            f.setSize(400, 300);
	            f.setVisible(true);
	        }
	        
	    }
	}


