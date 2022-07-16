package emp1;
import java.util.List;

 public class Employee {
	private  int empid ;
	private  String empname ;
	private  String designation ;
	private  int Daysattended ;
	private int Salary ;
	
	

	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public  int getDaysattended() {
		return Daysattended;
	}


	public void setDaysattended(int daysattended) {
		this.Daysattended = daysattended;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int Salary) {
		this.Salary = Salary;
	}
	


	public Employee(int empid, String empname, String designation, int daysattended,int Salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
		this.Daysattended = daysattended;
		this.Salary = Salary ;
	}
	
//	public String findEmployee(int empid) {
//		return empname;
//	}
//	


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


}


	

