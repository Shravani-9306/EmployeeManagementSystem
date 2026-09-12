package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceAdd extends Applet implements ActionListener{
	Label l1,l2,l3,l4,l5;
	Button b1;
	TextField t1,t2,t3;
	public void init() {
	l1=new Label("Add Attendance");
	l2=new Label("Employee Id ");
	t1=new TextField(20);
	l3=new Label("Attendance Date ");
	t2=new TextField(20);
	l4=new Label("Status ");
	t3=new TextField(20);
	l5=new Label("");
	b1=new Button("Add");
	
	add(l1);
	add(l2);
	add(t1);
	add(l3);
	add(t2);
	add(l4);
	add(t3);
	add(l5);
	add(b1);
	
	b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		    try {
		    	int emp_id = Integer.parseInt(t1.getText());
		    	Date att_date = Date.valueOf(t2.getText());
		        String status=t3.getText();

		        Attendance a = new Attendance();
		        a.setEmp_id(emp_id);
		        a.setAtt_date(att_date);
		        a.setStatus(status);

		        EmployeeMgtController emc = new EmployeeMgtController();
		        boolean b = emc.add(a);

		        if(b) {
		            l5.setText("Attendance Added Successfully");
		        }
		        else {
		            l5.setText("Attendance Added Failed");
		        }
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }
		}
	}

}
