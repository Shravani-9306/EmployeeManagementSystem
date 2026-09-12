package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class DepartmentUpdate extends Applet implements ActionListener{
	Label l1,l2,l3,l4;
	TextField t1,t2;
	Button b1,b2;
	public void init() {
		l1=new Label("Update Department");
		l2=new Label("Department Id: ");
		t1=new TextField(20);
		l3=new Label("Department Name:");
		t2=new TextField(20);
		b1=new Button("Search");
		b2=new Button("Update");
		l4=new Label("");
		
		add(l1);
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		add(b1);
		add(b2);
		add(l4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				int dept_id = Integer.parseInt(t1.getText());
		        EmployeeMgtController emc = new EmployeeMgtController();
		        Department d = emc.department(dept_id);
		        if(d != null) {
		        	t2.setText(d.getDept_name());
		        }
		        else {
		        	l4.setText("Department Not Found");
		        }
			}
			 catch(Exception e) {
			        e.printStackTrace();
			    }
		}
		if(ae.getSource() == b2) {
		    try {
		        int dept_id = Integer.parseInt(t1.getText());

		        Department d = new Department();

		        d.setDept_id(dept_id);
		        d.setDept_name(t2.getText());

		        EmployeeMgtController emc = new EmployeeMgtController();

		        boolean b = emc.update(d);

		        if(b) {
		            l4.setText("Department Updated Successfully");
		        }
		        else {
		            l4.setText("Department Update Failed");
		        }
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }
			
			
		}
	}

}
