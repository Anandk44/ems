package com.emp.exceptions;

public class EmpNotFoundException extends Exception {
	private int empid ;

	public EmpNotFoundException(int empid) {
		this.empid = empid ;
	}
	public String toString() {
		return "Employee Not Found Exception " + this.empid;

}
}
