package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends Applet implements ActionListener{
	Frame dashboard;
	
	Label l1,l2;
	Button b1,b2,b3,b4,b5,b6;
	public void init() {
		l1 = new Label("Welcome Admin");

	    b1 = new Button("Employee Management");
	    b2 = new Button("Department Management");
	    b3 = new Button("Attendance Management");
	    b4 = new Button("Payroll Management");
	    b5 = new Button("Reports Management");
	    l2=new Label("");
	    b6 = new Button("Log Out");
	   

	    add(l1);
	    add(b1);
	    add(b2);
	    add(b3);
	    add(b4);
	    add(b5);
	    add(l2);
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
    		
               Frame f = new Frame("Employee Management");
               
               EmployeeManagement em=new EmployeeManagement();

                f.add(em);

                em.init();

                f.setSize(400, 400);
                f.setVisible(true);
                dashboard.dispose();
            }
		if(ae.getSource()==b2) {
    		
            Frame f = new Frame("Department Management");
            
            DepartmentManagement dm=new DepartmentManagement();

             f.add(dm);

             dm.init();

             f.setSize(400, 400);
             f.setVisible(true);
             dashboard.dispose();
         }
		if(ae.getSource()==b3) {

		    Frame f = new Frame("Attendance Management");

		    AttendanceManagement am = new AttendanceManagement();

		    f.add(am);

		    am.init();

		    f.setSize(400, 400);
		    f.setVisible(true);
		}
		if(ae.getSource()==b4) {

		    Frame f = new Frame("Payroll Management");

		    PayrollManagement pm = new PayrollManagement();

		    f.add(pm);

		    pm.init();

		    f.setSize(400, 400);
		    f.setVisible(true);
		}
		if(ae.getSource() == b5) {

		    Frame f = new Frame("Reports Management");

		    ReportsManagement rm = new ReportsManagement();

		    f.add(rm);
		    rm.init();

		    f.setSize(400, 400);
		    f.setVisible(true);
		}

		if(ae.getSource()==b6) {
    		
            l2.setText("Logout Successful ");
           
                Frame f = new Frame("Employee Login");

                Login el = new Login();

                f.add(el);

                el.init();

                f.setSize(400, 400);
                f.setVisible(true);
                
            }
	}

}
