package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceUpdate extends Applet implements ActionListener {

    Label l1, l2, l3, l4, l5, l6;
    TextField t1, t2, t3, t4;
    Button b1, b2;

    public void init() {

        l1 = new Label("Update Attendance");

        l2 = new Label("Attendance Id: ");
        t1 = new TextField(20);

        l3 = new Label("Employee Id: ");
        t2 = new TextField(20);

        l4 = new Label("Attendance Date: ");
        t3 = new TextField(20);

        l5 = new Label("Status: ");
        t4 = new TextField(20);

        b1 = new Button("Search");
        b2 = new Button("Update");

        l6 = new Label("");

        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(l4);
        add(t3);
        add(l5);
        add(t4);
        add(b1);
        add(b2);
        add(l6);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1) {
            try {

                int att_id = Integer.parseInt(t1.getText());

                EmployeeMgtController emc = new EmployeeMgtController();

                Attendance a = emc.AttendanceById(att_id);

                if(a != null) {

                    t2.setText(String.valueOf(a.getEmp_id()));
                    t3.setText(String.valueOf(a.getAtt_date()));
                    t4.setText(a.getStatus());

                }
                else {
                    l6.setText("Attendance Not Found");
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(ae.getSource() == b2) {
            try {

                int att_id = Integer.parseInt(t1.getText());
                int emp_id = Integer.parseInt(t2.getText());
                Date att_date = Date.valueOf(t3.getText());
                String status = t4.getText();

                Attendance a = new Attendance();

                a.setAtt_id(att_id);
                a.setEmp_id(emp_id);
                a.setAtt_date(att_date);
                a.setStatus(status);

                EmployeeMgtController emc = new EmployeeMgtController();

                boolean b = emc.update(a);

                if(b) {
                    l6.setText("Attendance Updated Successfully");
                }
                else {
                    l6.setText("Attendance Update Failed");
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}