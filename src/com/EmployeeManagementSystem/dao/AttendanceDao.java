package com.EmployeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.bean.Employee;


public class AttendanceDao {

    public ArrayList<Attendance> attendance(int emp_id) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

        PreparedStatement pr = con.prepareStatement("select * from attendance where emp_id=?");
        pr.setInt(1, emp_id);
        
        ResultSet rs = pr.executeQuery();
        ArrayList<Attendance> arr = new ArrayList<Attendance>();
        while(rs.next()) {
            Attendance a = new Attendance();
            int att_id = rs.getInt(1);
            int empid = rs.getInt(2);
            Date att_date = rs.getDate(3);
            String status = rs.getString(4);
            a.setAtt_id(att_id);
            a.setEmp_id(empid);
            a.setAtt_date(att_date);
            a.setStatus(status);
            arr.add(a);
        }

        return arr;
    }
    public boolean add(Attendance a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	    PreparedStatement pr = con.prepareStatement("insert into attendance(emp_id,att_date,status) values(?,?,?)");
	    pr.setInt(1, a.getEmp_id());
	    pr.setDate(2,a.getAtt_date());
	    pr.setString(3, a.getStatus());
	    int i = pr.executeUpdate();

	    if(i==1) {
	    	return true;
	    }
	    else {
	        return false;
	    }	
	}
	public ArrayList<Attendance> view() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
        PreparedStatement pr = con.prepareStatement("select * from attendance");
        
        ResultSet rs = pr.executeQuery();
        ArrayList<Attendance> arr = new ArrayList<Attendance>();
        while(rs.next()) {
        	Attendance a = new Attendance();
            int att_id = rs.getInt(1);
            int emp_id = rs.getInt(2);
            Date att_date=rs.getDate(3);
            String status=rs.getString(4);
           a.setAtt_id(att_id);
           a.setEmp_id(emp_id);
            a.setAtt_date(att_date);
            a.setStatus(status);
            
            arr.add(a);
	}
        return arr;
	}
	public Attendance AttendanceById(int att_id) throws ClassNotFoundException, SQLException {

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("select * from attendance where att_id=?");
	    pr.setInt(1, att_id);

	    ResultSet rs = pr.executeQuery();
	    if(rs.next()) {

	       Attendance a = new Attendance();

	       int att_id1 = rs.getInt(1);
           int emp_id = rs.getInt(2);
           Date att_date=rs.getDate(3);
           String status=rs.getString(4);
           a.setAtt_id(att_id1);
           a.setEmp_id(emp_id);
           a.setAtt_date(att_date);
           a.setStatus(status);
	        return a;
	    }
	    else {
	        return null;
	    }
	}
	public boolean update(Attendance a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	    PreparedStatement pr = con.prepareStatement("update attendance set emp_id=?,att_date=?,status=? where att_id=?");
	    pr.setInt(1, a.getEmp_id());
	    pr.setDate(2, a.getAtt_date());
	    pr.setString(3, a.getStatus());
	    pr.setInt(4, a.getAtt_id());
	    
	    int i = pr.executeUpdate();

	    if(i==1) {
	    	return true;
	    }
	    else {
	        return false;
	    }	
	}
	public boolean delete(int att_id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("delete from attendance where att_id=?");
		pr.setInt(1, att_id);
		
		int i = pr.executeUpdate();
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<Attendance> attendanceReport(Date fromDate, Date toDate) 
	        throws ClassNotFoundException, SQLException {

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem", "root", "root");
	    PreparedStatement pr = con.prepareStatement("select * from attendance where att_date between ? and ?");

	    ArrayList<Attendance> arr = new ArrayList<Attendance>();
	    pr.setDate(1, fromDate);
	    pr.setDate(2, toDate);

	    ResultSet rs = pr.executeQuery();

	    while(rs.next()) {

	        Attendance a = new Attendance();

	        int att_id = rs.getInt(1);
	        int emp_id = rs.getInt(2);
	        Date att_date = rs.getDate(3);
	        String status = rs.getString(4);

	        a.setAtt_id(att_id);
	        a.setEmp_id(emp_id);
	        a.setAtt_date(att_date);
	        a.setStatus(status);

	        arr.add(a);
	    }

	    return arr;
	}


	
}