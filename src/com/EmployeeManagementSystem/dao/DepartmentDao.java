package com.EmployeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Department;


public class DepartmentDao {

	public Department department(int dept_id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	    PreparedStatement pr = con.prepareStatement("select * from department where dept_id=?");
	    pr.setInt(1, dept_id);
	    ResultSet rs = pr.executeQuery();

	    if(rs.next()) {
	    	Department d=new Department();
	    	int dept_id1=rs.getInt(1);
			String dept_name=rs.getString(2);
			d.setDept_id(dept_id1);
			d.setDept_name(dept_name);
	        return d;
	    }
	    else {
	        return null;
	    }	
	}
	public boolean add(Department d) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	    PreparedStatement pr = con.prepareStatement("insert into department(dept_name) values(?)");
	    pr.setString(1, d.getDept_name());
	    int i = pr.executeUpdate();

	    if(i==1) {
	    	return true;
	    }
	    else {
	        return false;
	    }	
	}
	public ArrayList<Department> view() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
        PreparedStatement pr = con.prepareStatement("select * from department");
        
        ResultSet rs = pr.executeQuery();
        ArrayList<Department> arr = new ArrayList<Department>();
        while(rs.next()) {
        	Department d = new Department();
            int deptid = rs.getInt(1);
            String department = rs.getString(2);
            d.setDept_id(deptid);
            d.setDept_name(department);
            
            arr.add(d);
	}
        return arr;
	}
	public boolean update(Department d) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	    PreparedStatement pr = con.prepareStatement("update department set dept_name=? where dept_id=?");
	    pr.setString(1, d.getDept_name());
	    pr.setInt(2, d.getDept_id());
	    int i = pr.executeUpdate();

	    if(i==1) {
	    	return true;
	    }
	    else {
	        return false;
	    }	
	}
	public boolean delete(int dept_id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("delete from department where dept_id=?");
		pr.setInt(1, dept_id);
		
		int i = pr.executeUpdate();
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
	}

}
