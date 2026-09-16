package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class PayrollSearch extends Applet implements ActionListener {

    Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField t1;
    Button b1;

    public void init() {

        l1 = new Label("Payroll Id: ");
        t1 = new TextField(20);
        l2 = new Label("Employee Id");
        l3 = new Label("Month");
        l4 = new Label("Basic Salary");
        l5 = new Label("Allowance");
        l6 = new Label("Deduction");
        l7 = new Label("Net Salary");
        l8 = new Label("");

        b1 = new Button("Search");

        add(l1);
        add(t1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(b1);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            try {
                int p_id = Integer.parseInt(t1.getText());
                EmployeeMgtController emc = new EmployeeMgtController();
                Payroll p = emc.PayrollById(p_id);

                if(p != null) {
                    l2.setText("Employee Id: " + p.getEmp_id());
                    l3.setText("Month: " + p.getMonth());
                    l4.setText("Basic Salary: " + p.getBasicSalary());
                    l5.setText("Allowance: " + p.getAllowance());
                    l6.setText("Deduction: " + p.getDeduction());
                    l7.setText("Net Salary: " + p.getNetSalary());
                } else {
                    l8.setText("Payroll Not Found");
                }

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}