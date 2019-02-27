package com.connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveServlet() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		          
		        String lastname=request.getParameter("lastname");  
		        String emailid=request.getParameter("emailid");  
		        String contactnumber=request.getParameter("contactnumber");  
		        Employee e=new Employee();  
		        e.setlastname(lastname);  
		        e.setemailid(emailid);  
		        e.setcontactnumber(contactnumber);  
		       
		          
		        int status=EmployeeDao.save(e);  
		        if(status>0){  
		            out.print("<p>Record saved successfully!</p>");  
		            request.getRequestDispatcher("index.html").include(request, response);  
		        }else{  
		            out.println("Sorry!unable to save record");  
		        }  
		          
		        out.close();  
		    }  
		  
		}  
	


