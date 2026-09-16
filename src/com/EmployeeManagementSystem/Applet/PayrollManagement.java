package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class PayrollManagement extends Applet implements ActionListener {

    Label l1;
    Button b1,b2,b3,b4,b5,b6;

    public void init() {

        l1 = new Label("Payroll Management");

        b1 = new Button("Add Payroll");
        b2 = new Button("View All Payroll");
        b3 = new Button("Search Payroll");
        b4 = new Button("Update Payroll");
        b5 = new Button("Delete Payroll");
        b6 = new Button("Back to Admin Dashboard");

        add(l1);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1) {

            Frame f = new Frame("Add Payroll");
            PayrollAdd pa = new PayrollAdd();
            f.add(pa);
            pa.init();
            f.setSize(400, 400);
            f.setVisible(true);
        }

        if(ae.getSource() == b2) {

            try {

                EmployeeMgtController emc = new EmployeeMgtController();

                ArrayList<Payroll> view = emc.viewPayroll();

                Frame f = new Frame("View Payroll");

                PayrollDetails pd = new PayrollDetails(view);

                f.add(pd);
                pd.init();

                f.setSize(400, 500);
                f.setVisible(true);

            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(ae.getSource() == b3) {

            Frame f = new Frame("Search Payroll");

            PayrollSearch ps = new PayrollSearch();

            f.add(ps);
            ps.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }

        if(ae.getSource() == b4) {

            Frame f = new Frame("Update Payroll");

            PayrollUpdate pu = new PayrollUpdate();

            f.add(pu);
            pu.init();

            f.setSize(400, 500);
            f.setVisible(true);
        }

        if(ae.getSource() == b5) {

            Frame f = new Frame("Delete Payroll");

            PayrollDelete pd = new PayrollDelete();

            f.add(pd);
            pd.init();

            f.setSize(400, 300);
            f.setVisible(true);
        }

        if(ae.getSource() == b6) {

            Frame f = new Frame("Admin Dashboard");

            AdminDashboard ad = new AdminDashboard();

            f.add(ad);
            ad.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }
    }
}