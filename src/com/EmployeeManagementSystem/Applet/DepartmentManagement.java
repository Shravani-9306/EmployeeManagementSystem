package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class DepartmentManagement extends Applet implements ActionListener{
Frame dashboard;
	
	Label l1;
	Button b1,b2,b3,b4,b5,b6;
	public void init() {
		l1 = new Label("Department Management");

	    b1 = new Button("Add Department");
	    b2 = new Button("View All Department");
	    b3 = new Button("Search Department");
	    b4 = new Button("Update Department");
	    b5 = new Button("Delete Department");
	    b6 = new Button("Back to Admin Dashboard");
	   
	   

	    add(l1);
	    add(b1);
	    add(b2);
	    add(b3);
	    add(b4);
	    add(b5);
	    add(b6);
	    
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	    b6.addActionListener(this);
	   
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			 Frame f = new Frame("Add Department");

			 DepartmentAdd ad = new DepartmentAdd();

	            f.add(ad);

	            ad.init();

	            f.setSize(400, 400);
	            f.setVisible(true);
		}
		if(ae.getSource()==b2) {
			try {
				EmployeeMgtController emc=new EmployeeMgtController();
				ArrayList<Department> view = emc.view();
				 Frame f = new Frame("View Department");
		            DepartmentView dv = new DepartmentView(view);
		            f.add(dv);
		            dv.init();
		            f.setSize(400, 400);
		            f.setVisible(true);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
			}
	
		if(ae.getSource() == b3) {
			
            Frame f = new Frame("Search Department");
            DepartmentSearch ds = new DepartmentSearch();
            f.add(ds);
            ds.init();
            f.setSize(400, 400);
            f.setVisible(true);
			
        }
		if(ae.getSource() == b4) {
			
            Frame f = new Frame("Update Department");
            DepartmentUpdate du = new DepartmentUpdate();
            f.add(du);
            du.init();
            f.setSize(400, 400);
            f.setVisible(true);
			
        }
		if(ae.getSource() == b5) {
			
            Frame f = new Frame("Delete Department");
            DepartmentDelete dd = new DepartmentDelete();
            f.add(dd);
            dd.init();
            f.setSize(400, 400);
            f.setVisible(true);	
        }
		if(ae.getSource() == b6) {

            Frame f = new Frame("Admin Dashboard");

            AdminDashboard ad = new AdminDashboard();

            f.add(ad);

            ad.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }
	}
		
	}

