package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.EmployeeManagementSystem.controller.EmployeeMgtController;

public class EmployeeForgotPassword extends Applet implements ActionListener {

    Label l1, l2, l3, l4, l5;
    TextField t1, t2, t3;
    Button b1, b2,b3;

    public void init() {

        l1 = new Label("Registered Email");
        l2 = new Label("New Password");
        l3 = new Label("Confirm Password");
        l4 = new Label("");
        l5 = new Label("");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);

        t2.setEchoChar('*');
        t3.setEchoChar('*');

        b1 = new Button("Check Email");
        b2 = new Button("Update Password");
        b3 = new Button("Back to Login"); 

        add(l1);
        add(t1);

        add(b1);

        add(l4);

        b1.addActionListener(this);

        t2.setVisible(false);
        t3.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        b2.setVisible(false);

        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b2);
        add(l5);
        add(b3);

        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {
            String email = t1.getText();
            if(email.isEmpty()) {
                l4.setText("Email is required");
                return;
            }

            try {

                EmployeeMgtController emc =new EmployeeMgtController();
                boolean status = emc.checkEmail(email);
                if(status == true) {

                    l4.setText("Email is registered");
                    l2.setVisible(true);
                    t2.setVisible(true);
                    l3.setVisible(true);
                    t3.setVisible(true);
                    b2.setVisible(true);

                }
                else {

                    l4.setText("Email is not registered");
                }

                validate();
                repaint();

            }
            catch(Exception ex) {

                ex.printStackTrace();
                l4.setText("Something went wrong");
            }
        }


        if(e.getSource() == b2) {

            String email = t1.getText();
            String newPassword = t2.getText();
            String confirmPassword = t3.getText();

            if(newPassword.isEmpty() ||
               confirmPassword.isEmpty()) {

                l5.setText("All fields are required");
                return;
            }

            try {

                EmployeeMgtController emc =new EmployeeMgtController();

                boolean result =emc.forgotPassword(email,newPassword,confirmPassword);

                if(result == true) {
                    l5.setText("Password Updated Successfully");
                }
                else {

                    l5.setText("Password does not match");
                }

            }
            catch(Exception ex) {

                ex.printStackTrace();
                l5.setText("Something went wrong");
            }
        }
        if(e.getSource() == b3) {

            Frame f = new Frame("Employee Login");

            Login el = new Login();

            f.add(el);

            el.init();

            f.setSize(400, 300);
            f.setVisible(true);
        }
    }
}