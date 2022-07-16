package com.emp.dao;
import com.emp.exceptions.EmpNotFoundException;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.emp.exceptions.EmpNotFoundException;

import emp1.Employee;

public class EmpDaoMysqlImpl implements IemployeeDao{
//	static Logger log = Logger.getLogger(Logger.class.getName());
	private Connection cn = null; 
	private PreparedStatement st = null ;
	private ResultSet rs = null ;
	public static final String INS_COMMAND = "INSERT INTO Employee VALUES(?,?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE Employee SET empname = ? , Designation = ? , dayattended = ? , Salary = ? WHERE empid = ?  ";
	public static final String DELETE_COMMAND = "DELETE FROM  Employee WHERE  empid = ? ";
	public static final String FIND_COMMAND = "SELECT empname FROM Employee WHERE empid=? " ;
	public static final String SELECT_ALL = "SELECT * FROM Employee";
	public static final String SALARY = "SELECT Salary FROM Employee WHERE empid = ? ";

	public EmpDaoMysqlImpl() {
		try {
		cn = DriverManager.getConnection(IemployeeDao.URL,IemployeeDao.UserName,IemployeeDao.Password);
	}catch(SQLException e) {
		System.out.println("unable to establishh the connection with db");
		e.printStackTrace();
	}
	}
	
	
	
	

	
	public void addEmployee(Employee e) {
		int i = 0 ;
		try {
			st = cn.prepareStatement(INS_COMMAND);
			st.setInt(1,  e.getEmpid());
			st.setString(2, e.getEmpname());
			st.setString(3,e.getDesignation());
			st.setInt(4, e.getDaysattended());
			st.setInt(5, e.getSalary());
			i = st.executeUpdate();
		} catch (SQLException e1) {
//		    LOGGER.log(Level.INFO, "ADDING RECORD FAILED.... UNABLE TO EXECUTE ");
			System.out.println("Adding record failed. unable to execute");
			e1.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(i>1) {
			System.out.println("Record added...");
		}
	}

	
	public void deleteEmployee(int empid) {
		int i = 0;
		try {
			st = cn.prepareStatement(DELETE_COMMAND);
			st.setInt(1,empid);
			i = st.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete operation failed... unable to execute command");
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(i>0){
			System.out.println("Record delete succesfully");
		}
		
	}

	
	public void updateEmployee(Employee e) {
		int i = 0 ;
		try {
			st = cn.prepareStatement(UPDATE_COMMAND);
			st.setInt(5,  e.getEmpid());
			st.setString(1, e.getEmpname());
			st.setString(2,e.getDesignation());
			st.setInt(3, e.getDaysattended());
			st.setInt(4, e.getSalary());
			i = st.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Update operation failed .. unable to update ");
			e1.printStackTrace();	
		}finally {
			try {
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(i>0) {
			System.out.println("Record updated succesfully");
		}
		
	}

	
	public String findEmployee(int empid) throws EmpNotFoundException {
		String findname = null ;
		try {
			st = cn.prepareStatement(FIND_COMMAND);
			st.setInt(1, empid);
			rs = st.executeQuery();
			while(rs.next()) {
				findname=rs.getString("empname");
				System.out.println("The name is : " + findname);
				 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			st.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	return findname;
	}

	public int getSalary(int empid) {
		int i = 0;
		try {
		st = cn.prepareStatement(SALARY);
		st.setInt(1, empid);
		rs = st.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			i = rs.getInt(1);
			
		}
	}catch(Exception e) {
		System.err.println("Employee not found");
		
	}finally {
		try {
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		return i ;
	

	
	}





	
	public List<Employee> showAllEmployees() {
		Employee selectAllTemp = null ;
		List<Employee> elist = new LinkedList<>();
		try {
			st = cn.prepareStatement(SELECT_ALL);
			rs= st.executeQuery();
			while(rs.next()) {
				selectAllTemp = new Employee();
				selectAllTemp.setEmpid(rs.getInt("empid"));
				selectAllTemp.setEmpname(rs.getString("empname"));
				selectAllTemp.setDesignation(rs.getString("designation"));
				selectAllTemp.setDaysattended(rs.getInt("dayattended"));
				selectAllTemp.setSalary(rs.getInt("Salary"));
				elist.add(selectAllTemp);	
			}
			return elist;
				
				
				
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}


