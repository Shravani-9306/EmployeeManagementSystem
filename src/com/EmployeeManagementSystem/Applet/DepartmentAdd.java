package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class DepartmentAdd extends Applet implements ActionListener{
	
	Label l1,l2,l3;
	Button b1;
	TextField t1;
	public void init() {
	l1=new Label("Add Department"+"\n");
	l2=new Label("Department Name: ");
	l3=new Label("");
	b1=new Button("Add");
	t1=new TextField(20);
	
	add(l1);
	add(l2);
	add(t1);
	add(b1);
	add(l3);
	
	b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		    try {
		        String dept_name = t1.getText();

		        Department d = new Department();
		        d.setDept_name(dept_name);

		        EmployeeMgtController emc = new EmployeeMgtController();

		        boolean b = emc.add(d);

		        if(b) {
		            l3.setText("Department Added Successfully");
		        }
		        else {
		            l3.setText("Department Add Failed");
		        }
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }
		}
	}
}
