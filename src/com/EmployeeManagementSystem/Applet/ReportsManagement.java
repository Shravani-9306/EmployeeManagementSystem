package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportsManagement extends Applet implements ActionListener {

    Label l1, l2;
    Button b1, b2, b3, b4;

    public void init() {

        l1 = new Label("Reports Management");

        b1 = new Button("Employee Registration Report");
        b2 = new Button("Attendance Report");
        b3 = new Button("Payroll Report");
        b4 = new Button("Back to Admin Dashboard");

        l2 = new Label("");

        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            Frame f = new Frame("Employee Registration Report");

            EmployeeReport er = new EmployeeReport();

            f.add(er);
            er.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }

        if(ae.getSource() == b2) {

            Frame f = new Frame("Attendance Report");

            AttendanceReport ar = new AttendanceReport();

            f.add(ar);
            ar.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }

        if(ae.getSource() == b3) {

            Frame f = new Frame("Payroll Report");

            PayrollReport pr = new PayrollReport();

            f.add(pr);
            pr.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }

        if (ae.getSource() == b4) {

            Frame f = new Frame("Admin Dashboard");

            AdminDashboard ad = new AdminDashboard();

            f.add(ad);
            ad.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }
    }
}