package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class EmployeeDashboard extends Applet implements ActionListener{
	Employee emp;
	Department dept;
	ArrayList<Attendance> attendance;
	ArrayList<Payroll> payroll;
	Frame dashboard;
	
	public EmployeeDashboard(){
		
	}
	public EmployeeDashboard(Employee emp) {
		this.emp=emp;
		
	}
	Label l1,l2;
	Button b1,b2,b3,b4,b5;
	
	public void init() {

		    l1 = new Label("Welcome Employee");

		    b1 = new Button("My Profile");
		    b2 = new Button("Department");
		    b3 = new Button("Attendance");
		    b4 = new Button("Payroll");
		    l2=new Label("");
		    b5 = new Button("Log Out");
		   

		    add(l1);
		    add(b1);
		    add(b2);
		    add(b3);
		    add(b4);
		    add(b5);
		    add(l2);
		    
		    b1.addActionListener(this);
		    b2.addActionListener(this);
		    b3.addActionListener(this);
		    b4.addActionListener(this);
		    b5.addActionListener(this);
	}
		    public void actionPerformed(ActionEvent ae) {
		    	if(ae.getSource()==b1) {
		    		Frame f = new Frame("My Profile");

		            EmployeeProfile ep = new EmployeeProfile(emp);

		            f.add(ep);

		            ep.init();

		            f.setSize(400, 300);
		            f.setVisible(true);
		    	}
		    	if(ae.getSource()==b2) {
		    		try {
		    		EmployeeMgtController em=new EmployeeMgtController();
		    		int a=emp.getEmp_deptid();
		    		dept=em.department(a);
		    		
		    		
		    		Frame f = new Frame("Department Details");

		    		DepartmentDetails dd = new DepartmentDetails(dept);

		            f.add(dd);

		            dd.init();

		            f.setSize(400, 300);
		            f.setVisible(true);
		    	}
		    		catch(Exception E){
		    			System.out.println("Something went wrong");
		    		}
		    }
		    	if(ae.getSource()==b3) {
		    		try {
		    		EmployeeMgtController em=new EmployeeMgtController();
		    		int b=emp.getEmp_id();
		    		attendance=em.attendance(b);
		    		
		    		
		    		Frame f = new Frame("Attendance Details");

		    		AttendanceDetails ad = new AttendanceDetails(attendance);

		            f.add(ad);

		            ad.init();

		            f.setSize(400, 300);
		            f.setVisible(true);
		    	}
		    		catch(Exception E){
		    			E.printStackTrace();
		    		}
		    }
		    	if(ae.getSource()==b4) {
		    		try {
		    		EmployeeMgtController em=new EmployeeMgtController();
		    		int c=emp.getEmp_id();
		    		payroll=em.payroll(c);
		    		
		    		
		    		Frame f = new Frame("Payroll Details");

		    		PayrollDetails pd = new PayrollDetails(payroll);

		            f.add(pd);

		            pd.init();

		            f.setSize(400, 300);
		            f.setVisible(true);
		    	}
		    		catch(Exception E){
		    			E.printStackTrace();
		    		}
		    }
		    	if(ae.getSource()==b5) {
		    		
		                     l2.setText("Logout Successful " + emp.getEmp_fname());
		                    
		                         Frame f = new Frame("Employee Login");

		                         Login el = new Login();

		                         f.add(el);

		                         el.init();

		                         f.setSize(400, 400);
		                         f.setVisible(true);
		                         dashboard.dispose();
		                     }
		    
		    	}
		    }
		    
		
		
	


