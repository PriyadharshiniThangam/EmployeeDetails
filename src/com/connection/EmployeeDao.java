package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public  static int save(Employee e){  
          int status=0;
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into employees(last_name,email_id,contact_number)values(?,?,?)");
            
            ps.setString(1,e.getlastname());  
            ps.setString(2,e.getemailid());  
            ps.setString(3,e.getcontactnumber());  
             
        status=ps.executeUpdate();  
              
            con.close();  
             
        }catch(Exception ex){ex.printStackTrace();}  
        return status; 
        
    }  
    public static int update(Employee e){  
        int status=0;
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update employees set last_name=?,email_id=?,contact_number=? where id=?");
            		
            ps.setString(1,e.getlastname());  
            ps.setString(2,e.getemailid());  
            ps.setString(3,e.getcontactnumber());
            ps.setInt(4,e.getid());  

           status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from employees where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static Employee getEmployeeById(int id){  
        Employee e=new Employee();  
          
        try{  
        	Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employees where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setlastname(rs.getString(1));  
                e.setemailid(rs.getString(2));  
                e.setcontactnumber(rs.getString(3));  
                e.setid(rs.getInt(4));

		    }
		    
		   
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Employee> getAllEmployees(){  
        List<Employee> list=new ArrayList<Employee>();  
          
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employees");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Employee e=new Employee();  
                e.setid(rs.getInt(1)); 
               

                e.setlastname(rs.getString(2));  
                e.setemailid(rs.getString(3));  
                e.setcontactnumber(rs.getString(4));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  

