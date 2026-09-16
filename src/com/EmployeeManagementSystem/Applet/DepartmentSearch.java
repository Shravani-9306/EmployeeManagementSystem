package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class DepartmentSearch extends Applet implements ActionListener{
	Label l1,l2;
	TextField t1;
	Button b1;
	public void init() {
	l1=new Label("Department Id:");
	l2=new Label("");
	t1=new TextField(20);
	b1=new Button("Search");
	
	add(l1);
	add(t1);
	add(l2);
	add(b1);
	
	b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				int dept_id = Integer.parseInt(t1.getText());
		        EmployeeMgtController emc = new EmployeeMgtController();
		        Department d = emc.department(dept_id);
		        if(d != null) {
		        	l2.setText(d.getDept_name());
		        }
		        else {
		        	l2.setText("Department Not Found");
		        }
			}
			 catch(Exception e) {
			        e.printStackTrace();
			    }
		}
	}
}
