package com.project.Student;



import java.io.IOException;

import com.pentagon.student.DAO.StudentDAO;
import com.pentagon.student.DAO.StudentDAOImlp;
import com.pentagon.studentDTO.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/update")
public class Update extends HttpServlet{
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		super.doGet(req, resp);
	}
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 StudentDAO dao = new StudentDAOImlp();  
 HttpSession session = req.getSession(false);
  Student s =(Student) session.getAttribute("student");
  s.setName(req.getParameter("name"));
  s.setPhone(Long.parseLong(req.getParameter("phone")));
  s.setEmail(req.getParameter("email"));
  s.setBranch(req.getParameter("branch"));
  s.setLocation(req.getParameter("location"));	
   if(dao.updateStudent(s)) {
	   session.setAttribute("success","updated");
	   resp.sendRedirect("dashboard.jsp");
	   
   }
   else {
	   session.setAttribute("fail","failed to update student");
	   resp.sendRedirect("dashboard.jsp");
   }
	
}
 
	

}
