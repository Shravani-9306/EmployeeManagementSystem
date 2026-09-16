package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceSearch extends Applet implements ActionListener{
	Label l1,l2,l3,l4,l5;
	TextField t1;
	Button b1;
	public void init() {
	l1=new Label("Attendance Id:");
	t1=new TextField(20);
	l2=new Label("Employee Id");
	l3=new Label("Date");
	l4=new Label("Status");
	l5=new Label("");
	b1=new Button("Search");
	
	add(l1);
	add(t1);
	add(l2);
	add(l3);
	add(l4);
	add(l5);
	add(b1);
	
	b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				int att_id = Integer.parseInt(t1.getText());
		        EmployeeMgtController emc = new EmployeeMgtController();
		        Attendance a = emc.AttendanceById(att_id);
		        if(a != null) {
		            l2.setText("Employee Id: " + a.getEmp_id());
		            l3.setText("Attendance Date: " + a.getAtt_date());
		            l4.setText("Status: " + a.getStatus());
		            
		         }
		        else {
		        	l5.setText("Attendance Not Found");
		        }
			}
			 catch(Exception e) {
			        e.printStackTrace();
			    }
		}
	}

}
