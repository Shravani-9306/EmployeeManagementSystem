package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class PayrollReport extends Applet implements ActionListener {

    Label l1, l2, l3, l4;
    TextField t1, t2;
    Button b1, b2, b3;

    ArrayList<Payroll> arr = new ArrayList<Payroll>();

    public void init() {

        l1 = new Label("Payroll Report");
        l2 = new Label("From Month (yyyy-mm):");
        t1 = new TextField(15);
        l3 = new Label("To Month (yyyy-mm):");
        t2 = new TextField(15);
        b1 = new Button("Generate Report");
        b2 = new Button("Export to Excel");
        b3 = new Button("Back");
        l4 = new Label("");

        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);
        add(b2);
        add(b3);
        add(l4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1) {

            try {

                String fromMonth = t1.getText();
                String toMonth = t2.getText();

                EmployeeMgtController emc = new EmployeeMgtController();

                arr = emc.payrollReport(fromMonth, toMonth);

                l4.setText("Total Payroll Records: " + arr.size());

            } catch(Exception e) {

                l4.setText("Enter month in yyyy-mm format");
            }
        }

        if(ae.getSource() == b2) {

            try {

                if(arr.isEmpty()) {
                    l4.setText("Generate Report First");
                    return;
                }

                File f = new File(
                    "D:\\DO IT\\Shravani\\PayrollReport.xls"
                );

                FileWriter fw = new FileWriter(f);

                fw.write("Payroll ID\t");
                fw.write("Employee ID\t");
                fw.write("Month\t");
                fw.write("Basic Salary\t");
                fw.write("Allowance\t");
                fw.write("Deduction\t");
                fw.write("Net Salary\n");

                for(Payroll p : arr) {

                    fw.write(p.getP_id() + "\t");
                    fw.write(p.getEmp_id() + "\t");
                    fw.write(p.getMonth() + "\t");
                    fw.write(p.getBasicSalary() + "\t");
                    fw.write(p.getAllowance() + "\t");
                    fw.write(p.getDeduction() + "\t");
                    fw.write(p.getNetSalary() + "\n");
                }

                fw.write("\nTotal Payroll Records\t" + arr.size());
                fw.close();
                l4.setText("Excel Report Generated Successfully");

            } catch(IOException e) {
                l4.setText("Error while creating Excel file");
            }
        }

        if(ae.getSource() == b3) {
            Frame f = new Frame("Reports Management");
            ReportsManagement rm = new ReportsManagement();
            f.add(rm);
            rm.init();
            f.setSize(400, 400);
            f.setVisible(true);
        }
    }
}