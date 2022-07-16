package com.emp.service;

import java.util.List;

import com.emp.exceptions.EmpNotFoundException;

import emp1.Employee;



public interface IEmployeeService {
	public abstract void addEmployee(Employee e);
	public abstract void deleteEmployee(int empid);
	public abstract void updateEmployee(Employee e);
	public abstract String findEmployee(int empid) throws EmpNotFoundException ;
	public abstract int Salary(int empid );
	public List<Employee>showAllEmployees();

}
