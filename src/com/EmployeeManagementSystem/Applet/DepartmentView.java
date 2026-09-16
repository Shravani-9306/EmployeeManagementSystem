package com.EmployeeManagementSystem.Applet;

import java.applet.Applet;
import java.awt.Label;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Department;

public class DepartmentView extends Applet {

    ArrayList<Department> arr;

    public DepartmentView(ArrayList<Department> arr) {
        this.arr = arr;
    }

    public void init() {

        if(arr.isEmpty()) {
            Label l1 = new Label("Department Record Is Not Found");
            add(l1);
        }
        else {
            for(Department d : arr) {
                Label l1 = new Label("Department Id: " + d.getDept_id());
                Label l2 = new Label("Department Name: " + d.getDept_name());

                add(l1);
                add(l2);
            }
        }
    }
}