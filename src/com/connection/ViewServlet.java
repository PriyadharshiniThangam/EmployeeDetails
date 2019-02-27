package com.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='index.html'>Add</a>");  
	        out.println("<h1>Employees List</h1>");  
	          
	        List<Employee> list=EmployeeDao.getAllEmployees();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>LastName</th><th>EmailId</th><th>Edit</th><th>Delete</th></tr>");  
	        for(Employee e:list){ 
	        	out.print("<tr><td>"+e.getid()+"</td><td>"+e.getlastname()+"</td>  <td>"+e.getemailid()+"</td><td>"+e.getcontactnumber()+"</td><td><a href='EditServlet?id="+e.getid()+"'>edit</a></td>   <td><a href='DeleteServlet?id="+e.getid()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
	        request.getRequestDispatcher("/included.html").include(request, response);

	    }  
	}  
	
