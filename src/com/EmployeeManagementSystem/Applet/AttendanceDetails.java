package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;


public class AttendanceDetails extends Applet{
	ArrayList<Attendance> arr;
	public AttendanceDetails(ArrayList<Attendance> arr) {
		this.arr=arr;
	}
	
	Label l1,l2,l3,l4,l5;
	public void init() {
		if(arr.isEmpty()) {
			l5=new Label("No Attendance Record Found");
			add(l5);
		}
		else {
		for(Attendance a:arr) {
			l1=new Label("Attendance Id: "+a.getAtt_id());
			l2=new Label("Employee Id: "+a.getEmp_id());
			l3=new Label("Attendance Date: "+a.getAtt_date());
			l4=new Label("Status: "+a.getStatus());
			
			
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			
		}
	}
	}
}
