package com.mypack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Statement;
public class DAOServlet {

	    public Connection getSqlConnection()
			{
				Connection con=null;
				 try
			     {
			      Class.forName("com.mysql.jdbc.Driver");
			      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","password");
			     }
				 catch (SQLException e) {         
			         System.out.println(e);

			        } catch(ClassNotFoundException x){
			         System.out.println(x);

			        } catch(Exception e){
			         System.out.println(e);
			        }          
				 return con;
			}
	 public ArrayList<EmployeeData> getAllEmployees()
	 {
		 ArrayList<EmployeeData> empCol = new ArrayList<EmployeeData>();
		 try
		 {
			 Connection con = getSqlConnection();
			 Statement stat = (Statement) con.createStatement();
			 ResultSet res = stat.executeQuery("select * from demo.employee");
			 while(res.next())
			 {
				 EmployeeData emp= new EmployeeData();
				 emp.setId(res.getInt(1));
				 emp.setName(res.getString(2));
				 emp.setPassword(res.getString(3));
				 emp.setEmail(res.getString(4));
				 emp.setCountry(res.getString(5));
				 empCol.add(emp);
				}
		 }
		 catch(Exception e) {
		 }
			 return empCol;
		 
	 }
		
		public int insertEmployeeData(EmployeeData emp) {
			int i=0;
		   try{
			   
			Connection con = getSqlConnection();
			PreparedStatement stat=con.prepareStatement("insert into demo.employee(name,password,email,country) values(?,?,?,?)");
			stat.setString(1, emp.getName());
			stat.setString(2,emp.getPassword());
			stat.setString(3, emp.getEmail());
			stat.setString(4, emp.getCountry());
			i=stat.executeUpdate();
			}
		    
	         
		catch(Exception e){
	         System.out.println(e);
	        }          
		return i;
	}
		
	public EmployeeData getEmployeeById(int id)
	{
		EmployeeData emp = new EmployeeData();
		try {
			Connection con = getSqlConnection();
			PreparedStatement ps = con.prepareStatement("select * from demo.employee where ID=? ");
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			if(res.next()) {
				emp.setId(res.getInt(1));
				emp.setName(res.getString(2));
				emp.setPassword(res.getString(3));
				emp.setEmail(res.getString(4));
				emp.setCountry(res.getString(5));
				
			}
			
		}
		catch(Exception e)
		{ 
		}
		
	return emp;
}
 public int UpdateEmployeeData(EmployeeData emp)
 {
	 int i=0;
	 try
	 {
		 Connection con = getSqlConnection();
		 PreparedStatement stat = con.prepareStatement("update demo.employee set name=?,password=?,email=?,country=? where ID=?");
		 stat.setString(1, emp.getName());
		 stat.setString(2, emp.getPassword());
		 stat.setString(3, emp.getEmail());
		 stat.setString(4, emp.getCountry());
		 stat.setInt(5, emp.getId());
		 i=stat.executeUpdate();
	 }
		 
				catch(Exception e)
	 {}
	 return i;
		 
		 
	 }
 public int DeleteEmployeeData(int id)
	{
		int i=0;		 
	     try
	     {
	    	 Connection con=getSqlConnection();
	            PreparedStatement stat=con.prepareStatement("delete from demo.employee where ID=?");
	            stat.setInt(1, id);	            
	            i=  stat.executeUpdate();
	     } catch(Exception e){
	         System.out.println(e);
	        }          
	     return i;
	}
 }




