package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class EmployeeUpdate extends Applet implements ActionListener{
	TextField t1,t2,t3,t4,t5,t6;
	Button b1,b2;
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	public void init() {
	l1=new Label("Update Employee");
	l2 = new Label("Employee Id");
	l3 = new Label("Employee First Name");
    l4 = new Label("Employee Last Name");
    l5 = new Label("Email");
    l6 = new Label("Mobile");
    l7 = new Label("Department");
    l8=new Label("");
    
    t1 = new TextField(20);
    t2 = new TextField(20);
    t3 = new TextField(20);
    t4 = new TextField(20);
    t5 = new TextField(20);
    t6 = new TextField(20);
    
    b1=new Button("Search");
    b2=new Button("Update");
    
    add(l1);
    add(l2);
    add(t1);
    add(l3);
    add(t2);
    add(l4);
    add(t3);
    add(l5);
    add(t4);
    add(l6);
    add(t5);
    add(l7);
    add(t6);
    add(l8);
    add(b1);
    add(b2);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
	if(ae.getSource() == b1) {
	    try {
	        int emp_id = Integer.parseInt(t1.getText());
	        EmployeeMgtController emc = new EmployeeMgtController();
	        Employee e = emc.employeeById(emp_id);
	        if(e != null) {
	        	t2.setText(e.getEmp_fname());
	        	t3.setText(e.getEmp_lname());
	        	t4.setText(e.getEmp_email());
	        	t5.setText(e.getEmp_mob());
	        	t6.setText("" + e.getEmp_deptid());
	        }
	        else {
	            l8.setText("Employee Not Found");
	        }
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	if(ae.getSource() == b2) {
	    try {
	        int emp_id = Integer.parseInt(t1.getText());

	        Employee e1 = new Employee();

	        e1.setEmp_id(emp_id);
	        e1.setEmp_name(t2.getText());
	        e1.setEmp_lname(t3.getText());
	        e1.setEmp_email(t4.getText());
	        e1.setEmp_mob(t5.getText());
	        e1.setEmp_deptid(Integer.parseInt(t6.getText()));

	        EmployeeMgtController emc = new EmployeeMgtController();

	        boolean b = emc.update(e1);

	        if(b) {
	            l8.setText("Employee Updated Successfully");
	        }
	        else {
	            l8.setText("Employee Update Failed");
	        }
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	    
	}
}
