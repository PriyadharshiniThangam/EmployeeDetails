package com.connection;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class SaveController
 */
@WebServlet("/SaveController")
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String lastname=request.getParameter("lastname");
		String emailid=request.getParameter("emailid");
		String contactnumber=request.getParameter("contactnumber");
		if (lastname.isEmpty()||emailid.isEmpty()||contactnumber.isEmpty() ) {
			response.sendRedirect("signup.jsp");
			   out.println("Please fill all the fields");
		}
		else
		{
			try
			{
				 Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root"); 
				    String query = "insert into employee_user(last_name,email_id,contact_number)values(?,?,?)";
				    PreparedStatement ps = con.prepareStatement(query);
				    ps.setString(1, lastname);
				    ps.setString(2, emailid);
				    ps.setString(3, contactnumber);
				    int i=ps.executeUpdate();
				    if(i>0)
				    {
				    System.out.println("successfuly inserted");
				    response.sendRedirect("ViewServlet");
				    }
				    
				    ps.close();
				    con.close();
				   } catch (ClassNotFoundException|SQLException e) {
				   
				    e.printStackTrace();
				   }
				 
				  }
				 }
}
			
		
	


