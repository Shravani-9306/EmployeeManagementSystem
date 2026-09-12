package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;

import com.EmployeeManagementSystem.bean.Employee;

public class EmployeeProfile extends Applet{
	Employee emp;
	public EmployeeProfile(Employee emp) {
		this.emp=emp;
	}
	Label l1, l2, l3, l4, l5, l6, l7;
	public void init() {
		l1 = new Label("Employee ID :"+"\t"+emp.getEmp_id());
		l2 = new Label("First Name :"+"\t"+emp.getEmp_fname());
        l3 = new Label("Last Name :"+"\t"+emp.getEmp_lname());
        l4 = new Label("Email :"+"\t"+emp.getEmp_email());
        l5 = new Label("Mobile :"+"\t"+emp.getEmp_mob());
        l6 = new Label("Department ID :"+"\t"+emp.getEmp_deptid());
        l7 = new Label("Joining Date :"+"\t"+emp.getEmp_joindate());
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        
	}

	
}
