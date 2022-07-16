package com.emp.dao;

import java.util.List;

import com.emp.exceptions.EmpNotFoundException;

import emp1.Employee;

public interface IemployeeDao {
	public abstract void addEmployee(Employee e);
	public abstract void deleteEmployee(int empid);
	public abstract void updateEmployee(Employee e);
	public abstract String findEmployee(int empid) throws EmpNotFoundException ;
	public abstract int getSalary(int empid);
	public List<Employee>showAllEmployees();
	public static final String URL = "jdbc:mysql://localhost:3306/employee";
	public static final String UserName = "root" ;
	public static final String Password = "123456";
	public static final String Driver_Class = "com.mysql.cj.jdbc.Driver";

}
