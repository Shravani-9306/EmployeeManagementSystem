package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class EmployeeDelete extends Applet implements ActionListener{
	TextField t1;
	Button b1;
	Label l1,l2,l3;
	
	public void init() {
		l1=new Label("Delete Employee");
		l2=new Label("Employee Id: ");
		l3=new Label("");
		b1=new Button("Delete");
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
		        int emp_id = Integer.parseInt(t1.getText());

		        EmployeeMgtController emc = new EmployeeMgtController();

		        boolean b = emc.delete(emp_id);

		        if(b) {
		            l3.setText("Delete Successfully");
		        }
		        else {
		            l3.setText("Employee Not Found");
		        }
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }
		}
	}

}
