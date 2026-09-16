package com.EmployeeManagementSystem.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.EmployeeManagementSystem.bean.Attendance;
import com.EmployeeManagementSystem.bean.Department;
import com.EmployeeManagementSystem.bean.Employee;
import com.EmployeeManagementSystem.bean.Payroll;
import com.EmployeeManagementSystem.dao.AttendanceDao;
import com.EmployeeManagementSystem.dao.DepartmentDao;
import com.EmployeeManagementSystem.dao.EmployeeDao;
import com.EmployeeManagementSystem.dao.PayrollDao;

public class EmployeeMgtController {
	
	public boolean empreg(String fname, String lname,String email, String password, String confirmPassword, String mobile, int dept,
			Date date) throws ClassNotFoundException, SQLException {
		
		String nameregex = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
		if(fname.matches(nameregex)) {
		    
		} else {
		    return false;
		}
		String lnameregex = "^[A-Z][a-z]*( [A-Z][a-z]*)*$";
		if(lname.matches(lnameregex)) {
		    
		} else {
		    return false;
		}
		
		String emailreg="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if(email.matches(emailreg)) {

		}
		else {
			System.out.println("Invalid Email");
			return false;
		}
		
		String mobnoreg="^(\\+91)?[6-9][0-9]{9}$";
		if(mobile.matches(mobnoreg)) {

		}
		else {
			System.out.println("Mobile No Format is not matches:");
			return false;
		}
		
		String passwordreg="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$";
		if(password.matches(passwordreg)) {

		}
		else {
			System.out.println("Password is not matches:");
			return false;
		}
		if(password.equals(confirmPassword)) {
			Employee e=new Employee();
			
			e.setEmp_name(fname);
			e.setEmp_lname(lname);
			e.setEmp_email(email);
			e.setEmp_password(password);
			e.setEmp_mob(mobile);
			e.setEmp_deptid(dept);
			e.setEmp_joindate(date);
			EmployeeDao ed=new EmployeeDao();
			boolean regstatus=ed.register(e);
			if(regstatus==true) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public Employee emplogin(String email, String password) throws ClassNotFoundException, SQLException {
		Employee e=new Employee();
		e.setEmp_email(email);
		e.setEmp_password(password);
		
		EmployeeDao ed=new EmployeeDao();
		boolean loginstatus=ed.login(e);
		if(loginstatus==true) {
			return e;
		}
		else {
			return null;
		}
	}

	public boolean forgotPassword(String email, String newPassword, String confirmPassword)
	        throws ClassNotFoundException, SQLException {

	    if(newPassword.equals(confirmPassword)) {
	        Employee e = new Employee();
	        e.setEmp_email(email);
	        e.setEmp_password(newPassword);
	        EmployeeDao ed = new EmployeeDao();
	        boolean status = ed.forgotPassword(e);
	        if(status == true) {
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
	    else {
	        return false;
	    }
	}
	public boolean checkEmail(String email)
	        throws ClassNotFoundException, SQLException {

	    EmployeeDao ed = new EmployeeDao();

	    boolean status = ed.checkEmail(email);

	    if(status == true) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	public Department department(int dept_id) throws ClassNotFoundException, SQLException {
		
		DepartmentDao dd=new DepartmentDao();
		Department deptid=dd.department(dept_id);
		
			return deptid;	
	}
	public ArrayList<Attendance> attendance(int emp_id) throws ClassNotFoundException, SQLException {

	    AttendanceDao ad = new AttendanceDao();
	    ArrayList<Attendance> arr = ad.attendance(emp_id);
	    return arr;
	}
	public boolean add(Attendance a) throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    boolean b = ad.add(a);
	    return b;
	}

	public ArrayList<Attendance> viewAttendance()throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    ArrayList<Attendance> arr = ad.view();
	    return arr;
	}

	public Attendance AttendanceById(int att_id)throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    Attendance a = ad.AttendanceById(att_id);
	    return a;
	}

	public boolean update(Attendance a)throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    boolean b = ad.update(a);
	    return b;
	}

	public boolean deleteAttendance(int att_id)throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    boolean b = ad.delete(att_id);
	    return b;
	}
	public ArrayList<Payroll> payroll(int emp_id) throws ClassNotFoundException, SQLException {

	    PayrollDao pd = new PayrollDao();
	    ArrayList<Payroll> arr = pd.payroll(emp_id);
	    return arr;
	}
	public boolean add(Payroll p) throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    boolean b = pd.add(p);
	    return b;
	}

	public ArrayList<Payroll> viewPayroll()throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    ArrayList<Payroll> arr = pd.view();
	    return arr;
	}

	public Payroll PayrollById(int p_id)throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    Payroll p = pd.PayrollById(p_id);
	    return p;
	}

	public boolean update(Payroll p)throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    boolean b = pd.update(p);
	    return b;
	}

	public boolean deletePayroll(int p_id)throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    boolean b = pd.delete(p_id);
	    return b;
	}
	public boolean AdminCredentials(String ad_email,String ad_password) {
		String email="shravanik494@gmail.com";
		String password="Shrav_ani@09";
		
		if(email.equals(ad_email)&& password.equals(ad_password)) {
			return true;
		}
		else {
			return false;
		}	
	}
	public ArrayList<Employee> show() throws ClassNotFoundException, SQLException {

	    EmployeeDao ed = new EmployeeDao();
	    ArrayList<Employee> arr = ed.show();
	    return arr;
	}
	public Employee employeeById(int emp_id) throws ClassNotFoundException, SQLException {
	    EmployeeDao ed = new EmployeeDao();
	    Employee e = ed.employeeById(emp_id);
	    return e;
	}
	public boolean update(Employee e) throws ClassNotFoundException, SQLException {
	    EmployeeDao ed = new EmployeeDao();
	    boolean b = ed.update(e);
	    return b;
	}
	public boolean delete(int emp_id) throws ClassNotFoundException, SQLException {
	    EmployeeDao ed = new EmployeeDao();
	    boolean b = ed.delete(emp_id);
	    return b;
	}
	public boolean add(Department d) throws ClassNotFoundException, SQLException {
	    DepartmentDao dd = new DepartmentDao();
	    boolean b = dd.add(d);
	    return b;
	}
	public ArrayList<Department> view() throws ClassNotFoundException, SQLException {
	    DepartmentDao dd = new DepartmentDao();
	    ArrayList<Department> arr = dd.view();
	    return arr;
	}
	public boolean update(Department d) throws ClassNotFoundException, SQLException {
	    DepartmentDao dd = new DepartmentDao();
	    boolean b = dd.update(d);
	    return b;
	}
	public boolean delete1(int dept_id) throws ClassNotFoundException, SQLException {
	    DepartmentDao dd = new DepartmentDao();
	    boolean b = dd.delete(dept_id);
	    return b;
	}
	public ArrayList<Employee> employeeReport(Date fromDate, Date toDate) throws ClassNotFoundException, SQLException {
	    EmployeeDao ed = new EmployeeDao();
	    ArrayList<Employee> arr = ed.employeeReport(fromDate, toDate);
	    return arr;
	}
	public ArrayList<Attendance> attendanceReport(Date fromDate, Date toDate)throws ClassNotFoundException, SQLException {
	    AttendanceDao ad = new AttendanceDao();
	    ArrayList<Attendance> arr = ad.attendanceReport(fromDate, toDate);
	    return arr;
	}
	public ArrayList<Payroll> payrollReport(String fromMonth, String toMonth)throws ClassNotFoundException, SQLException {
	    PayrollDao pd = new PayrollDao();
	    ArrayList<Payroll> arr = pd.payrollReport(fromMonth, toMonth);
	    return arr;
	}
	
}


