package com.EmployeeManagementSystem.dao;

import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.bean.Payroll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayrollDao {
	
	    public ArrayList<Payroll> payroll(int emp_id) throws ClassNotFoundException, SQLException{

	    	Class.forName("com.mysql.jdbc.Driver");

	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	        PreparedStatement pr = con.prepareStatement("select * from payroll where emp_id=?");
	        pr.setInt(1, emp_id);
	        
	        ResultSet rs = pr.executeQuery();
	        ArrayList<Payroll> arr = new ArrayList<Payroll>();
	        while(rs.next()) {
	        	Payroll p = new Payroll();
	            
	            int p_id = rs.getInt(1);
	            int empid = rs.getInt(2);
	            String month = rs.getString(3);
	            double basicSalary = rs.getDouble(4);
	            double allowance = rs.getDouble(5);
	            double deduction = rs.getDouble(6);
	            double netSalary = rs.getDouble(7);
	          
	            p.setP_id(p_id);
	            p.setEmp_id(empid);
	            p.setMonth(month);
	            p.setBasicSalary(basicSalary);
	            p.setAllowance(allowance);
	            p.setDeduction(deduction);
	            p.setNetSalary(netSalary);
	           
	           
	            arr.add(p);
	        }

	        return arr;
	    }
	    public boolean add(Payroll p) throws ClassNotFoundException, SQLException {

	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	        PreparedStatement pr = con.prepareStatement("insert into payroll(emp_id,month,basicSalary,allowance,deduction,netSalary) values(?,?,?,?,?,?)");

	        pr.setInt(1, p.getEmp_id());
	        pr.setString(2, p.getMonth());
	        pr.setDouble(3, p.getBasicSalary());
	        pr.setDouble(4, p.getAllowance());
	        pr.setDouble(5, p.getDeduction());
	        pr.setDouble(6, p.getNetSalary());

	        int i = pr.executeUpdate();

	        if(i == 1) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	        public ArrayList<Payroll> view() throws ClassNotFoundException, SQLException {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem", "root","root");
	            PreparedStatement pr = con.prepareStatement("select * from payroll");

	            ResultSet rs = pr.executeQuery();
	            ArrayList<Payroll> arr = new ArrayList<Payroll>();

	            while(rs.next()) {

	                Payroll p = new Payroll();
	                int p_id = rs.getInt(1);
	                int emp_id = rs.getInt(2);
	                String month = rs.getString(3);
	                double basicSalary = rs.getDouble(4);
	                double allowance = rs.getDouble(5);
	                double deduction = rs.getDouble(6);
	                double netSalary = rs.getDouble(7);

	                p.setP_id(p_id);
	                p.setEmp_id(emp_id);
	                p.setMonth(month);
	                p.setBasicSalary(basicSalary);
	                p.setAllowance(allowance);
	                p.setDeduction(deduction);
	                p.setNetSalary(netSalary);
	                arr.add(p);
	            }
	            return arr;
	        }
	        public Payroll PayrollById(int p_id) throws ClassNotFoundException, SQLException {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");
	            PreparedStatement pr = con.prepareStatement("select * from payroll where p_id=?");
	            pr.setInt(1, p_id);

	            ResultSet rs = pr.executeQuery();

	            if(rs.next()) {

	                Payroll p = new Payroll();
	                int p_id1 = rs.getInt(1);
	                int emp_id = rs.getInt(2);
	                String month = rs.getString(3);
	                double basicSalary = rs.getDouble(4);
	                double allowance = rs.getDouble(5);
	                double deduction = rs.getDouble(6);
	                double netSalary = rs.getDouble(7);

	                p.setP_id(p_id1);
	                p.setEmp_id(emp_id);
	                p.setMonth(month);
	                p.setBasicSalary(basicSalary);
	                p.setAllowance(allowance);
	                p.setDeduction(deduction);
	                p.setNetSalary(netSalary);

	                return p;
	            }
	            else {
	                return null;
	            }
	        }
	        public boolean update(Payroll p) throws ClassNotFoundException, SQLException {

	            Class.forName("com.mysql.jdbc.Driver");

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	            PreparedStatement pr = con.prepareStatement("update payroll set emp_id=?,month=?,basicSalary=?,allowance=?,deduction=?,netSalary=? where p_id=?");

	            pr.setInt(1, p.getEmp_id());
	            pr.setString(2, p.getMonth());
	            pr.setDouble(3, p.getBasicSalary());
	            pr.setDouble(4, p.getAllowance());
	            pr.setDouble(5, p.getDeduction());
	            pr.setDouble(6, p.getNetSalary());
	            pr.setInt(7, p.getP_id());

	            int i = pr.executeUpdate();

	            if(i == 1) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	        public boolean delete(int p_id) throws ClassNotFoundException, SQLException {

	            Class.forName("com.mysql.jdbc.Driver");

	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem","root","root");

	            PreparedStatement pr = con.prepareStatement("delete from payroll where p_id=?");

	            pr.setInt(1, p_id);

	            int i = pr.executeUpdate();

	            if(i == 1) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	        public ArrayList<Payroll> payrollReport(String fromMonth, String toMonth) throws ClassNotFoundException, SQLException {

	    	    Class.forName("com.mysql.jdbc.Driver");
	    	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemgtsystem", "root", "root");
	    	    PreparedStatement pr = con.prepareStatement("select * from payroll where month between ? and ?");

	    	    ArrayList<Payroll> arr = new ArrayList<Payroll>();

	    	    pr.setString(1, fromMonth);
	    	    pr.setString(2, toMonth);

	    	    ResultSet rs = pr.executeQuery();

	    	    while(rs.next()) {
	    	    	
	    	    	Payroll p=new Payroll();
	    	    	
	    	    	int p_id = rs.getInt(1);
		            int empid = rs.getInt(2);
		            String month = rs.getString(3);
		            double basicSalary = rs.getDouble(4);
		            double allowance = rs.getDouble(5);
		            double deduction = rs.getDouble(6);
		            double netSalary = rs.getDouble(7);
		          
		            p.setP_id(p_id);
		            p.setEmp_id(empid);
		            p.setMonth(month);
		            p.setBasicSalary(basicSalary);
		            p.setAllowance(allowance);
		            p.setDeduction(deduction);
		            p.setNetSalary(netSalary);
		           
		           
		            arr.add(p);
		        }
	    	    return arr;
	    	}
}
