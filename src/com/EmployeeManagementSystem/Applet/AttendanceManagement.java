package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceManagement extends Applet implements ActionListener{
Frame dashboard;
	
	Label l1;
	Button b1,b2,b3,b4,b5,b6;
	public void init() {
		l1 = new Label("Attendance Management");

	    b1 = new Button("Add Attendance");
	    b2 = new Button("View All Attendance");
	    b3 = new Button("Search Attendance");
	    b4 = new Button("Update Attendance");
	    b5 = new Button("Delete Attendance");
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
			 Frame f = new Frame("Add Attendance");

			 AttendanceAdd aa = new AttendanceAdd();

	            f.add(aa);

	            aa.init();

	            f.setSize(400, 400);
	            f.setVisible(true);
		}
		if(ae.getSource()==b2) {
			try {
				EmployeeMgtController emc=new EmployeeMgtController();
				ArrayList<Attendance> view = emc.viewAttendance();
				 Frame f = new Frame("View Attendance");
				 AttendanceDetails ad = new AttendanceDetails(view);
		            f.add(ad);
		            ad.init();
		            f.setSize(400, 400);
		            f.setVisible(true);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
			}
	
		if(ae.getSource() == b3) {
			
            Frame f = new Frame("Search Attendance");
            AttendanceSearch as = new AttendanceSearch();
            f.add(as);
            as.init();
            f.setSize(400, 400);
            f.setVisible(true);
			
        }
		if(ae.getSource() == b4) {
			
            Frame f = new Frame("Update Attendance");
            AttendanceUpdate au = new AttendanceUpdate();
            f.add(au);
            au.init();
            f.setSize(400, 400);
            f.setVisible(true);
			
        }
		if(ae.getSource() == b5) {
			
            Frame f = new Frame("Delete Attendance");
            AttendanceDelete ad = new AttendanceDelete();
            f.add(ad);
            ad.init();
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
