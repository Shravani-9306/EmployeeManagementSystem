package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class PayrollAdd extends Applet implements ActionListener{	
    	Label l1,l2,l3,l4,l5,l6,l7,l8;
	    TextField t1,t2,t3,t4,t5,t6;
	    Button b1;

	    public void init() {
	        l1 = new Label("Add Payroll");
	        l2 = new Label("Employee Id: ");
	        t1 = new TextField(20);
	        l3 = new Label("Month: ");
	        t2 = new TextField(20);
	        l4 = new Label("Basic Salary: ");
	        t3 = new TextField(20);
	        l5 = new Label("Allowance: ");
	        t4 = new TextField(20);
	        l6 = new Label("Deduction: ");
	        t5 = new TextField(20);
	        l7 = new Label("Net Salary: ");
	        t6 = new TextField(20);
	        l8 = new Label("");
	        b1 = new Button("Add");

	        add(l1);
	        add(l2);
	        add(t1);
	        add(l3);
	        add(t2);
	        add(l4);
	        add(t3);
	        add(l5);
	        add(t4);
	        add(l6);
	        add(t5);
	        add(l7);
	        add(t6);
	        add(l8);
	        add(b1);

	        b1.addActionListener(this);
	    }

	    public void actionPerformed(ActionEvent ae) {

	        if(ae.getSource() == b1) {

	            try {

	                int emp_id = Integer.parseInt(t1.getText());
	                String month = t2.getText();
	                double basicSalary = Double.parseDouble(t3.getText());
	                double allowance = Double.parseDouble(t4.getText());
	                double deduction = Double.parseDouble(t5.getText());
	                double netSalary = Double.parseDouble(t6.getText());

	                Payroll p = new Payroll();

	                p.setEmp_id(emp_id);
	                p.setMonth(month);
	                p.setBasicSalary(basicSalary);
	                p.setAllowance(allowance);
	                p.setDeduction(deduction);
	                p.setNetSalary(netSalary);

	                EmployeeMgtController emc = new EmployeeMgtController();

	                boolean b = emc.add(p);

	                if(b) {
	                    l8.setText("Payroll Added Successfully");
	                }
	                else {
	                    l8.setText("Payroll Added Failed");
	                }

	            }
	            catch(Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
