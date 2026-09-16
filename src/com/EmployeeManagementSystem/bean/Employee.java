package com.EmployeeManagementSystem.bean;

import java.sql.Date;

public class Employee {
	private int emp_id;
	private String emp_fname;
	private String emp_email;
	private String emp_password;
	private String emp_mob;
	private int emp_deptid;
	private Date emp_joindate;
	private String emp_lname;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_fname() {
		return emp_fname;
	}
	public void setEmp_name(String emp_fname) {
		this.emp_fname = emp_fname;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	public String getEmp_mob() {
		return emp_mob;
	}
	public void setEmp_mob(String emp_mob) {
		this.emp_mob = emp_mob;
	}
	public int getEmp_deptid() {
		return emp_deptid;
	}
	public void setEmp_deptid(int dept) {
		this.emp_deptid = dept;
	}
	public Date getEmp_joindate() {
		return emp_joindate;
	}
	public void setEmp_joindate(Date date) {
		this.emp_joindate = date;
	}
	public void setEmp_lname(String lname) {
		this.emp_lname = lname;
		
	}
	public String getEmp_lname() {
		return emp_lname;
	}
	
	
	
}
