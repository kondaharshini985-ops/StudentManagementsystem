package com.project.Student;


import java.io.IOException;
import java.io.PrintWriter;

import com.pentagon.student.DAO.StudentDAO;
import com.pentagon.student.DAO.StudentDAOImlp;
import com.pentagon.studentDTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class SignUp extends HttpServlet{
	
	   @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {

	        doPost(req, res);
	    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		Student s = new Student();
		StudentDAO sdao = new StudentDAOImlp();
     	PrintWriter out =res.getWriter();
//		String name =req.getParameter("name");
//		s.setName(name);
        s.setName(req.getParameter("name"));
     
        s.setPhone(Long.parseLong(req.getParameter("phone")));

        s.setEmail(req.getParameter("email"));
        s.setBranch(req.getParameter("branch"));
        s.setLocation(req.getParameter("location"));
        String pass =req.getParameter("password");
        String confirm =req.getParameter("confirmpassword");
        if(pass.equals(confirm)) {
        	s.setPassword(pass);
        	boolean result =sdao.insertStudent(s);
        	if(result) {
//        		System.out.println("data saved successfully");
//        		out.println("<h1>data saved successfully</h1>");//if want than only give h1 like that
        		
        	   req.setAttribute("success","data saved");
        	   RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
        	   rd.forward(req, res);
        	}else{
//        		System.out.println("data not saved");
//        		out.println("<h2>data not saved</h2>");
        		req.setAttribute("fail", "data failed to save");
        		RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
        		rd.forward(req, res);
        	}
        }else {
//        	System.out.println("password mismatch ");
//        	out.println("<h2>password missmatch</h2>");
        	req.setAttribute("fail", "password mismatched");
    		RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
    		rd.forward(req, res);
        }
		
	} 

	
	
	}



 