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

@WebServlet("/updatepassword")
public class UpdatePassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession(false);
		Student s =(Student)session.getAttribute("student");
		if(s==null||session==null) {
			session =req.getSession(true);
			session.setAttribute("fail","session expired");
			resp.sendRedirect("login.jsp");//login ki redirect ayye la vhudali endhuku ante session close ayindi ante info em led annatu so malli login avvali em cheyyali anna
			return;
		}
		StudentDAO dao = new StudentDAOImlp();
		String oldPassword =req.getParameter("oldpassword");
		String newPassword =req.getParameter("newpassword");
		String confirmPassword =req.getParameter("confirmpassword");
				
		if(!s.getPassword().equals(oldPassword)) {
			session.setAttribute("fail", "old password incorrect");
			resp.sendRedirect("dashboard.jsp");
			return;
		}
		if(oldPassword.equals(newPassword)) {
			session.setAttribute("fail", "this password is already used use new password");
			resp.sendRedirect("dashboard.jsp");
			return;
		}
		if(!newPassword.equals(confirmPassword)) {
			session.setAttribute("fail", "password mismatched");
			resp.sendRedirect("dashboard.jsp");
			return;
		}
		s.setPassword(newPassword);
		if(dao.updateStudent(s)) {
			session.setAttribute("pass", "password upated");
			resp.sendRedirect("dashboard.jsp");
			return;
	
		}else {
			session.setAttribute("fail", " failed to update password ");
			resp.sendRedirect("dashboard.jsp");
			return;
	
	}

	}}
