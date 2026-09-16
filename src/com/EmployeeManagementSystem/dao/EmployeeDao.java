package com.EmployeeManagementSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Employee;


public class EmployeeDao {

	public boolean register(Employee e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
		PreparedStatement pr=con.prepareStatement("insert into employee(emp_fname,emp_lname,emp_email,emp_password,emp_mob,emp_deptid,emp_joindate) values(?,?,?,?,?,?,?)");
		
		pr.setString(1, e.getEmp_fname());
		pr.setString(2, e.getEmp_lname());
		pr.setString(3, e.getEmp_email());
		pr.setString(4, e.getEmp_password());
		pr.setString(5,e.getEmp_mob());
		pr.setInt(6,e.getEmp_deptid());
		pr.setDate(7, e.getEmp_joindate());
		
		int i=pr.executeUpdate();
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
}

	public boolean login(Employee e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");	
		PreparedStatement pr=con.prepareStatement("Select * from employee where emp_email=? and emp_password=?");
		
		pr.setString(1, e.getEmp_email());
		pr.setString(2, e.getEmp_password());
			
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String mob=rs.getString(6);
				int deptid=rs.getInt(7);
				Date joindate=rs.getDate(8);
				e.setEmp_id(id);
				e.setEmp_name(fname);
				e.setEmp_lname(lname);
				e.setEmp_email(email);
				e.setEmp_mob(mob);
				e.setEmp_deptid(deptid);
				e.setEmp_joindate(joindate);
				return true;
			}
			else {
				return false;
			}		
	}

	public boolean forgotPassword(Employee e) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("update employee set emp_password=? where emp_email=?");

	    pr.setString(1, e.getEmp_password());
	    pr.setString(2, e.getEmp_email());

	    int i = pr.executeUpdate();
	    if(i == 1) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("select * from employee where emp_email=?");
	    pr.setString(1, email);
	    ResultSet rs = pr.executeQuery();

	    if(rs.next()) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	public ArrayList<Employee> show ()throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
		PreparedStatement pr=con.prepareStatement("Select * from employee");
		ArrayList<Employee>arr=new ArrayList<Employee>();
			
			ResultSet rs=pr.executeQuery();
			while(rs.next()) {
				Employee e1=new Employee();
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String mob=rs.getString(6);
				int deptid=rs.getInt(7);
				Date joindate=rs.getDate(8);
				
				e1.setEmp_id(id);
				e1.setEmp_name(fname);
				e1.setEmp_lname(lname);
				e1.setEmp_email(email);
				e1.setEmp_mob(mob);
				e1.setEmp_deptid(deptid);
				e1.setEmp_joindate(joindate);
				arr.add(e1);
			}
			return arr;		
	}
	public Employee employeeById(int emp_id) throws ClassNotFoundException, SQLException {

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("select * from employee where emp_id=?");
	    pr.setInt(1, emp_id);

	    ResultSet rs = pr.executeQuery();
	    if(rs.next()) {

	        Employee e = new Employee();

	        int id = rs.getInt(1);
	        String fname = rs.getString(2);
	        String lname = rs.getString(3);
	        String email = rs.getString(4);
	        String mob = rs.getString(6);
	        int deptid = rs.getInt(7);
	        Date joindate = rs.getDate(8);

	        e.setEmp_id(id);
	        e.setEmp_name(fname);
	        e.setEmp_lname(lname);
	        e.setEmp_email(email);
	        e.setEmp_mob(mob);
	        e.setEmp_deptid(deptid);
	        e.setEmp_joindate(joindate);

	        return e;
	    }
	    else {
	        return null;
	    }
	}
	public boolean update(Employee e) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("update employee  set emp_fname=?, emp_lname=?, emp_email=?, emp_mob=?, emp_deptid=? where emp_id=?");
		
	    pr.setString(1, e.getEmp_fname());
	    pr.setString(2, e.getEmp_lname());
	    pr.setString(3, e.getEmp_email());
	    pr.setString(4, e.getEmp_mob());
	    pr.setInt(5, e.getEmp_deptid());
	    pr.setInt(6, e.getEmp_id());
		
	    int i = pr.executeUpdate();

	    if(i == 1) {
	        return true;
	    }
	    else {
	        return false;
	    }	
	}
	public boolean delete(int emp_id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	    PreparedStatement pr = con.prepareStatement("delete from employee where emp_id=?");
		pr.setInt(1, emp_id);
		
		int i = pr.executeUpdate();
		if(i==1) {
			return true;
		}
		else {
			return false;
		}
	}
	public ArrayList<Employee> employeeReport(Date fromDate, Date toDate) throws ClassNotFoundException, SQLException {

	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem", "root", "root");
	    PreparedStatement pr = con.prepareStatement("select * from employee where emp_joindate between ? and ?");

	    ArrayList<Employee> arr = new ArrayList<Employee>();

	    pr.setDate(1, fromDate);
	    pr.setDate(2, toDate);

	    ResultSet rs = pr.executeQuery();

	    while(rs.next()) {

	        Employee e2 = new Employee();

	        int id = rs.getInt(1);
	        String fname = rs.getString(2);
	        String email = rs.getString(4);
	        String password = rs.getString(5);
	        String mob = rs.getString(6);
	        int deptid = rs.getInt(7);
	        Date joindate = rs.getDate(8);

	        e2.setEmp_id(id);
	        e2.setEmp_name(fname);
	        e2.setEmp_email(email);
	        e2.setEmp_password(password);
	        e2.setEmp_mob(mob);
	        e2.setEmp_deptid(deptid);
	        e2.setEmp_joindate(joindate);

	        arr.add(e2);
	    }

	    return arr;
	}
}
