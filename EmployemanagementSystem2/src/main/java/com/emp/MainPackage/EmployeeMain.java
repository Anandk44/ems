package com.emp.MainPackage;

import java.util.List;
import java.util.Scanner;

import com.emp.exceptions.EmpNotFoundException;
import com.emp.service.EmployeeServiceImpl;
import com.emp.service.IEmployeeService;

import emp1.Employee;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		IEmployeeService eservice = new EmployeeServiceImpl();
		System.out.println(" Welcome to Employee management system ");
		System.out.println(" ");
		System.out.println("Please Enter your Admin_username : ");
		String Username = sc.nextLine();
		System.out.println("please enter your Admin_password : ");
		String Password = sc.nextLine();

		int choice=0;
		if(Username.equals("Anand1234") && Password.equals("Easports12")){
	            System.out.println("\t\tWelcome to Admin Page");
	            System.out.println();
	            
	         
	            while(true) {
	            	
	            	System.out.println("Choose the action you want to perform ");
	            	System.out.println("PR3w3w33ESS 1 to ADD Employee ");
	    			System.out.println("PRESS 2 to DELETE Employee");
	    			System.out.println("PRESS 3 to Update Employee");
	    			System.out.println("PRESS 4 to Find Employee");
	    			System.out.println("PRESS 5 to print all Employees : ");
	    			System.out.println("PRESS 6 to For Salary of Employee : ");
	    			System.out.println("PRESS 7 to EXIT App");
	                try {
	    			choice = sc.nextInt();
	    			sc.nextLine();
	                }catch(Exception e) {
	                	e.printStackTrace();
	                	main(null);
	                }
	                switch(choice) {
	                case 1 :
	                	System.out.println("Enter Employee Information : ");
	                	System.out.println("please enter empname : ");
	                	String empname = sc.nextLine();
	                	System.out.println("please enter Employee designation : ");
	                	String Designation = sc.nextLine();
	                	System.out.println("please enter empid : ");
	                	int empid = sc.nextInt();
	                	System.out.println("please enter number of days employee attended : ");
	                	int Daysattended = sc.nextInt();
	                	System.out.println("Please enter Employee salary : ");
	                	int Salary = sc.nextInt();
	                	
	                	
	                	eservice.addEmployee(new Employee(empid, empname, Designation,Daysattended,Salary));
	                	
	                	break;
	                case 2 :
	                	System.out.println("Enter empid to delete Employee Infomation : ");
	                	int id = sc.nextInt();
	                	eservice.deleteEmployee(id);
	                	break;
	                case 3 :
	                	System.out.println("Enter empid to update Employee Information  :  ");
	                	int Update_id = Integer.parseInt(sc.nextLine());
	                	System.out.println("Enter new empname : ");
	                	String new_Name = sc.nextLine();
	                	System.out.println("Enter new Employee Designation ; ");
	                	String new_Designation = sc.nextLine();
	                	System.out.println("Enter no of days attended : ");
	                	int new_daysattended = sc.nextInt();
	                	System.out.println("enter new salary : ");
	                	int new_sal = sc.nextInt();
	                	eservice.updateEmployee(new Employee(Update_id ,new_Name, new_Designation, new_daysattended, new_sal ));
	                	
	                	break;
	                case 4 :
	                	System.out.println("Enter Employee id to find Employee :");
	                	int findemp = sc.nextInt();
	                	try {
							eservice.findEmployee(findemp);
						} catch (EmpNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	                	
	                	
	                		
	                	break;
	                case 5 :
	                     List<Employee> elist = eservice.showAllEmployees();
	                     for(Employee e : elist) {
	                    	 System.out.println(" Employee Id  : " + e.getEmpid() + " Employee Name  : " + e.getEmpname() + " Employee Designation  : " + e.getDesignation() + " Daysattended by Employee :  " + e.getDaysattended() + " Employee salary is : " + e.getSalary());
	                     }
	                case 6 :
	                	System.out.println("Enter empid to get salary information :");
	                	int empid_ = sc.nextInt();
	                	eservice.Salary(empid_);
	                	break;
	                case 7 :
	                	System.out.println("Thank you for using Employee management  ");
	                	System.exit(0);
	                	break;
	                default:
	                	System.out.println("wrong option");
	                }  
	                }  
		}
	            else {
	            	System.out.println("Invalid user name or password");
	            	EmployeeMain.main(null);
	            }
		



}
}
