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
import java.sql.Date;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class AttendanceReport extends Applet implements ActionListener {

    Label l1, l2, l3, l4;
    TextField t1, t2;
    Button b1, b2, b3;

    ArrayList<Attendance> arr = new ArrayList<Attendance>();
    public void init() {

        l1 = new Label("Attendance Report");
        l2 = new Label("From Date (yyyy-mm-dd):");
        t1 = new TextField(15);
        l3 = new Label("To Date (yyyy-mm-dd):");
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

                Date fromDate = Date.valueOf(t1.getText());
                Date toDate = Date.valueOf(t2.getText());

                EmployeeMgtController emc = new EmployeeMgtController();

                arr = emc.attendanceReport(fromDate, toDate);

                l4.setText("Total Attendance Records: " + arr.size());

            } catch(Exception e) {

                l4.setText("Enter date in yyyy-mm-dd format");
            }
        }

        if(ae.getSource() == b2) {

            try {

                if(arr.isEmpty()) {
                    l4.setText("Generate Report First");
                    return;
                }

                File f = new File("D:\\DO IT\\Shravani\\AttendanceReport.xls");

                FileWriter fw = new FileWriter(f);

                fw.write("Attendance ID\t");
                fw.write("Employee ID\t");
                fw.write("Attendance Date\t");
                fw.write("Status\n");

                for(Attendance a : arr) {

                    fw.write(a.getAtt_id() + "\t");
                    fw.write(a.getEmp_id() + "\t");
                    fw.write(a.getAtt_date() + "\t");
                    fw.write(a.getStatus() + "\n");
                }

                fw.write("\nTotal Attendance Records\t" + arr.size());

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