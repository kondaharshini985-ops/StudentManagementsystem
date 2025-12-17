package com.project.Student;

import java.io.IOException;
import java.net.ResponseCache;

import org.eclipse.jdt.internal.compiler.batch.BatchCompilerRequestor;

import com.pentagon.student.DAO.StudentDAO;
import com.pentagon.student.DAO.StudentDAOImlp;
import com.pentagon.studentDTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    doPost(req, res);  // Forward GET to POST
	}
	
	

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	Student s=null;
	StudentDAO std = new StudentDAOImlp();
//	PrintWriter out = res.getWriter();
	String email =req.getParameter("email");
	String password =req.getParameter("password");
	 s =std.getStudent(password, email);
	if(s!= null) {
//		out.println("login sussessfull");
		 
		  req.setAttribute("success", "login successfull");
//		  req.setAttribute("student", s);//replace with session
          HttpSession session =req.getSession();
		  session.setAttribute("student", s);
		  RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
		  rd.forward(req, res);
	  }
	else {
//        out.println("Go to signuppage");
		 HttpSession session =req.getSession();
		  session.setAttribute("fail", "go to signup page");
		  res.sendRedirect("login.jsp");
//		  RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//		  rd.forward(req, res);
	  }
      
	}
	
}
