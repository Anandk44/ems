package com.emp.service;

import java.util.List;

import com.emp.dao.EmpDaoMysqlImpl;
import com.emp.dao.IemployeeDao;
import com.emp.exceptions.EmpNotFoundException;

import emp1.Employee;

public class EmployeeServiceImpl implements IEmployeeService  {
	private IemployeeDao empDao  = new EmpDaoMysqlImpl();

	@Override
	public void addEmployee(Employee e) {
		empDao.addEmployee(e);
		
	}

	@Override
	public void deleteEmployee(int empid) {
		empDao.deleteEmployee(empid);
	}

	@Override
	public void updateEmployee(Employee e) {
		empDao.updateEmployee(e);
		
	}
	@Override

	public String findEmployee(int empid) throws EmpNotFoundException {
		return  empDao.findEmployee(empid);
		
	}
	public int Salary(int empid) {
		return empDao.getSalary(empid);
	}

	@Override
	public List<Employee> showAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.showAllEmployees();
	}
	


 

}
