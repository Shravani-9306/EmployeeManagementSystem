package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;

import com.EmployeeManagementSystem.bean.Department;

public class DepartmentDetails extends Applet{
	Department dept;
	public DepartmentDetails(Department dept) {
		this.dept=dept;
	}
	Label l1,l2;
	public void init() {
		l1=new Label("Department Id:"+"\t"+dept.getDept_id());
		l2=new Label("Department Name:"+"\t"+dept.getDept_name());
		
		add(l1);
		add(l2);
	}

}
