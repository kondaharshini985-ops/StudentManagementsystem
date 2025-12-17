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

@WebServlet("/forget")
public class ForgetPassword extends HttpServlet{

@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
		}
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
	 Student s=null;
	  StudentDAO sdo = new StudentDAOImlp();
//	  PrintWriter out =res.getWriter();
      String email=req.getParameter("email");
      Long phone =Long.parseLong(req.getParameter("phone"));
      s=sdo.getStudentByName(email, phone);
      if(s == null){
    	    req.setAttribute("fail","Invalid email or phone number");
    	    req.getRequestDispatcher("forgetpassword.jsp").forward(req,res);
    	    return;
    	}

      String password =req.getParameter("password");
      String confirmpassword =req.getParameter("confirmpassword");
      if(confirmpassword.equals(password)) {
    	  if(s.getPassword().equals(password)) {
//    		  out.print("<h2>password already used</h2>");
        	  req.setAttribute("fail", "password already used");
    		  RequestDispatcher rd = req.getRequestDispatcher("forgetpassword.jsp");
    		  rd.forward(req, res);
    		  
    	  }
    	  else {
    		  s.setPassword(password);
    		 
    		  if( sdo.updateStudent(s)) {
//    			  out.print("<h1>Password updated</h1>");
    			  req.setAttribute("pass", "password updated");
    			  RequestDispatcher rd = req.getRequestDispatcher("forgetpassword.jsp");
    			  rd.forward(req, res);
    		  }
    		  else {
//    			  out.print("failed to update");
    			  req.setAttribute("fail", " failed to update password");
    			  RequestDispatcher rd = req.getRequestDispatcher("forgetpassword.jsp");
    			  rd.forward(req, res);
    		  }
    	  }
      }else {
//    	  out.print("<h2>password mismatch</h2>");
    	  req.setAttribute("fail", "password mismatched");
		  RequestDispatcher rd = req.getRequestDispatcher("forgetpassword.jsp");
		  rd.forward(req, res);
    	  
      }
      
      
      
     
      }
    	  
      
      
}




