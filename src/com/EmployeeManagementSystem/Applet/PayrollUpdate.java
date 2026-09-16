package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class PayrollUpdate extends Applet implements ActionListener {

    Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
    TextField t1,t2,t3,t4,t5,t6,t7;
    Button b1,b2;

    public void init() {

        l1 = new Label("Update Payroll");

        l2 = new Label("Payroll Id: ");
        t1 = new TextField(20);

        l3 = new Label("Employee Id: ");
        t2 = new TextField(20);

        l4 = new Label("Month: ");
        t3 = new TextField(20);

        l5 = new Label("Basic Salary: ");
        t4 = new TextField(20);

        l6 = new Label("Allowance: ");
        t5 = new TextField(20);

        l7 = new Label("Deduction: ");
        t6 = new TextField(20);

        l8 = new Label("Net Salary: ");
        t7 = new TextField(20);
        l9=new Label("");

        b1 = new Button("Search");
        b2 = new Button("Update");

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
        add(t7);
        add(b1);
        add(b2);
        add(l9);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1) {

            try {

                int p_id = Integer.parseInt(t1.getText());

                EmployeeMgtController emc = new EmployeeMgtController();

                Payroll p = emc.PayrollById(p_id);

                if(p != null) {

                    t2.setText(String.valueOf(p.getEmp_id()));
                    t3.setText(p.getMonth());
                    t4.setText(String.valueOf(p.getBasicSalary()));
                    t5.setText(String.valueOf(p.getAllowance()));
                    t6.setText(String.valueOf(p.getDeduction()));
                    t7.setText(String.valueOf(p.getNetSalary()));

                } else {
                    l1.setText("Payroll Not Found");
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(ae.getSource() == b2) {

            try {

                int p_id = Integer.parseInt(t1.getText());
                int emp_id = Integer.parseInt(t2.getText());
                String month = t3.getText();
                double basicSalary = Double.parseDouble(t4.getText());
                double allowance = Double.parseDouble(t5.getText());
                double deduction = Double.parseDouble(t6.getText());
                double netSalary = Double.parseDouble(t7.getText());

                Payroll p = new Payroll();

                p.setP_id(p_id);
                p.setEmp_id(emp_id);
                p.setMonth(month);
                p.setBasicSalary(basicSalary);
                p.setAllowance(allowance);
                p.setDeduction(deduction);
                p.setNetSalary(netSalary);

                EmployeeMgtController emc = new EmployeeMgtController();

                boolean b = emc.update(p);

                if(b) {
                    l9.setText("Payroll Updated Successfully");
                } else {
                    l9.setText("Payroll Update Failed");
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}