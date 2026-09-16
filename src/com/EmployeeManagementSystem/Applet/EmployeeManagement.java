package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class EmployeeManagement extends Applet implements ActionListener {
Frame dashboard;
	
	Label l1,l2;
	Button b1,b2,b3,b4,b5;
	public void init() {
		l1 = new Label("Employee Management");

	    b1 = new Button("Add Employee");
	    b2 = new Button("View Employee");
	    b3 = new Button("Update Employee");
	    b4 = new Button("Delete Employee");
	    b5 = new Button("Back to Admin Dashboard");
	   
	   

	    add(l1);
	    add(b1);
	    add(b2);
	    add(b3);
	    add(b4);
	    add(b5);
	    
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	   

	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {

            Frame f = new Frame("Employee Registration");

            EmployeeRegistration er = new EmployeeRegistration();

            f.add(er);

            er.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }
		if(ae.getSource() == b2) {
			try {
			EmployeeMgtController emc=new EmployeeMgtController();
			ArrayList<Employee> view = emc.show();
            Frame f = new Frame("View Employee");
            EmployeeDetails ed = new EmployeeDetails(view);
            f.add(ed);
            ed.init();
            f.setSize(400, 400);
            f.setVisible(true);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
        }
		if(ae.getSource() == b3) {
			
            Frame f = new Frame("Update Employee");
            EmployeeUpdate eu = new EmployeeUpdate();
            f.add(eu);
            eu.init();
            f.setSize(400, 400);
            f.setVisible(true);
			
        }
		if(ae.getSource() == b4) {

		    Frame f = new Frame("Delete Employee");

		    EmployeeDelete ed = new EmployeeDelete();

		    f.add(ed);

		    ed.init();

		    f.setSize(400, 300);
		    f.setVisible(true);
		}
		 if(ae.getSource() == b5) {

	            Frame f = new Frame("Admin Dashboard");

	            AdminDashboard ad = new AdminDashboard();

	            f.add(ad);

	            ad.init();

	            f.setSize(400, 400);
	            f.setVisible(true);
	        }
		
	}
}
