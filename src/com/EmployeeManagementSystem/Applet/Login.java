package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class Login extends Applet implements ActionListener{
	Label l1,l2,l3;
    TextField t1, t2;
    
    Button b1,b2,b3;
    Frame loginFrame;
    
    public void init() {
    	l1 = new Label("Email");
    	l2 = new Label("Password");
    	l3 = new Label("");
    	t1 = new TextField(20);
        t2 = new TextField(20);
        
        b1 = new Button("Login");
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
       
        b2 = new Button("Forgot Password");
        add(b2);
        b2.addActionListener(this);
        b1.addActionListener(this);
        add(b1); 
        b3 = new Button("Back to Registration");
        b3.addActionListener(this);
        add(b3);
        add(l3);
        }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b2) {

            Frame f = new Frame("Forgot Password");

            EmployeeForgotPassword efp = new EmployeeForgotPassword();

            f.add(efp);

            efp.init();

            f.setSize(400, 300);
            f.setVisible(true);
        }

        if(e.getSource() == b1) {

            String email = t1.getText();
            String password = t2.getText();

            if(email.isEmpty() || password.isEmpty()) {
                l3.setText("All fields are required");
                return;
            }
            else {
            	EmployeeMgtController emc =new EmployeeMgtController();
                boolean check=emc.AdminCredentials(email, password);
                if(check==true) {
                        Frame f = new Frame("Admin Dashboard");

                        AdminDashboard ad = new AdminDashboard();
                        
                        f.add(ad);
                        ad.init();
                        f.setSize(400, 400);
                        f.setVisible(true);
                        loginFrame.dispose();
                        return;
                              
                    }
            }

            try {

                EmployeeMgtController emc =new EmployeeMgtController();

                Employee emp = emc.emplogin(email, password);

                if(emp != null) {
                    l3.setText("Login Successful " + emp.getEmp_fname());
                    
                        Frame f = new Frame("Employee Dashboard");

                        EmployeeDashboard ed = new EmployeeDashboard(emp);
                        ed.dashboard = f;
                        f.add(ed);

                        ed.init();

                        f.setSize(400, 400);
                        f.setVisible(true);
                        loginFrame.dispose();
                       
                    }
                
                
                else {
                    l3.setText("Please try again");
                }

            }
            catch(Exception ex) {
                ex.printStackTrace();
                l3.setText("Something went wrong");
            }
        }
        if(e.getSource() == b3) {

            Frame f = new Frame("Employee Registration");

            EmployeeRegistration er = new EmployeeRegistration();

            f.add(er);

            er.init();

            f.setSize(400, 400);
            f.setVisible(true);
        }
    }
}