package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Payroll;

public class PayrollDetails extends Applet{
	ArrayList<Payroll> arr;
	public PayrollDetails(ArrayList<Payroll> arr) {
		this.arr=arr;
	}
	
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	public void init() {
		if(arr.isEmpty()) {
			l8=new Label("Payroll Record Is Not Found");
			add(l8);
		}
		else {
		for(Payroll p:arr) {
			l1=new Label("Payroll Id: "+p.getP_id());
			l2=new Label("Employee Id: "+p.getEmp_id());
			l3=new Label("Month: "+p.getMonth());
			l4=new Label("Basic Salary: "+p.getBasicSalary());
			l5=new Label("Allowance: "+p.getAllowance());
			l6=new Label("Deduction: "+p.getDeduction());
            l7=new Label("NetSalary: "+p.getNetSalary());
           
			add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(l5);
			add(l6);
			add(l7);
			
		}
	}
	}
}
