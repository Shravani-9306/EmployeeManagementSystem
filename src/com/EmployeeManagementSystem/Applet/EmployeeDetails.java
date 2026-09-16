package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;
import java.util.ArrayList;
import com.EmployeeManagementSystem.bean.Employee;

public class EmployeeDetails extends Applet{
	ArrayList<Employee> view;
	public EmployeeDetails(ArrayList<Employee> view) {
		this.view=view;
	}

	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	public void init() {
		if(view.isEmpty()) {
			l9=new Label("Employee Record Is Not Found");
			add(l9);
		}
		else {
		for(Employee e : view) {
			l1=new Label("Employee Id: "+e.getEmp_id());
			l2=new Label("First Name: "+e.getEmp_fname());
			l3=new Label("Last Name: "+e.getEmp_lname());
			l4=new Label("Email: "+e.getEmp_email());
			l6=new Label("Mobile No: "+e.getEmp_mob());
            l7=new Label("Department Id: "+e.getEmp_deptid());
            l8=new Label("Joining Date: "+e.getEmp_joindate()+"\n");
           
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			
			add(l6);
			add(l7);
			add(l8);
			
		}
	}
	}
}
