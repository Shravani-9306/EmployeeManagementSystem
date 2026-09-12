package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceDelete extends Applet implements ActionListener{
	Label l1,l2,l3;
	TextField t1;
	Button b1;
	public void init() {
		l1=new Label("Delete Attendance");
		l2=new Label("Attendance Id: ");
		t1=new TextField(20);
		b1=new Button("Delete");
		l3=new Label("");
		
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
		        int att_id = Integer.parseInt(t1.getText());

		        EmployeeMgtController emc = new EmployeeMgtController();

		        boolean b = emc.deleteAttendance(att_id);

		        if(b) {
		            l3.setText("Delete Successfully");
		        }
		        else {
		            l3.setText("Attendance Record Not Found");
		        }
		    }
		    catch(Exception e) {
		        e.printStackTrace();
		    }
	}

	}

}
