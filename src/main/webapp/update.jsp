<%@ page import="com.pentagon.studentDTO.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE STUDENT</title>
</head>
<body>
<% Student s=(Student)session.getAttribute("student");
if(s!=null){%>

<form action="update" method="post">
<label>Id</label>
<input type="text"  name="id" value="<%=s.getSid()%>" readonly>
<label>name</label>
<input type="text" name="name" value="<%=s.getName() %>" required>
<label>phone</label>
<input type="tel" name="phone" value="<%=s.getPhone()%>" required>
<label>email</label>
<input type="email" name="email" value="<%=s.getEmail()%>" required>
<label>branch</label>
<input type="text" name="branch" value="<%=s.getBranch() %>" required>
<label>location</label>
<input type="text" name="location" value="<%=s.getLocation() %>" required>
<a href="dashboard.jsp" class="btn btn-primary">BACK</a>
<button class="btn btn-secondary">SUBMIT</button>

</form>
<%}
else{
	request.setAttribute("error", "session expired");
	RequestDispatcher rd =request.getRequestDispatcher("dashboard.jsp");
	rd.forward(request, response);
}
%>


</body>
</html>