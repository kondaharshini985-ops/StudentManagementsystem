<%@ page import="com.pentagon.studentDTO.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash_board</title>
<style>
		body{
			margin:0;
			padding: 0;
			box-sizing: border-box;
		}
		.header{
			display: flex;
			justify-content: space-between;
			align-items: center;
			background-color: black ;
			color: skyblue;

		}
		.navbar{
			display: flex;
			justify-content: space-evenly;
			gap: 15px;
		}
		.item{
			list-style-type: none;


		}
		a{
			text-decoration: none;
			color: skyblue;
		}
		.details{
			width:100%;
		}



	</style>
</head>
<body>
<%------<%if(request.getAttribute("success")!=null) {
<%=request.getAttribute("success") %>
<%} %>   ------%>
<% Student s=(Student)session.getAttribute("student");%>
<%-----<%if(request.getAttribute("success")!=null) {
<%=request.getAttribute("success") %>
<%} %>    --%>
<%
if(session.getAttribute("success")!= null) {
    out.println("<p style='color:green'>" + session.getAttribute("success") + "</p>");
    session.removeAttribute("success");

}

if(session.getAttribute("fail") != null) {
    out.println("<p style='color:red'>" + session.getAttribute("fail") + "</p>");
    session.removeAttribute("fail");
}

if(session.getAttribute("error") != null) {
    out.println("<p style='color:red'>" + session.getAttribute("error") + "</p>");
    session.removeAttribute("error");
}
%>






<div class="container">
	<div class=header>
		<h3 class="welcomeheading">WELCOME <%=s.getName() %></h3>
		<ul class="navbar">
			<li class="item"><%if(s.getSid()==239){ %><a href=ViewUser.jsp>ViewUser</a><%} %></li>
			<li class="item"><a href="update.jsp">Update</a></li>
			<li class="item"><a href="updatepassword.jsp">UpdatePassword</a></li>
			<li><a href="logout" class="item">Logout</a></li>

		</ul>
	</div>
	<div class="main_content">
		<center><h2>USER DETAILS</h2></center>
	<div class="content">
		<table class="details" border="2">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PHONE</th>
				<th>EMAIL</th>
				<th>BRANCH</th>
				<th>LOCATION</th>

			</tr>
			<tr>
				<th> <%=s.getSid() %></th>
				<th> <%=s.getName() %></th>
				<th> <%=s.getPhone()%></th>
				<th> <%=s.getEmail() %></th>
				<th> <%=s.getBranch() %></th>
				<th> <%=s.getLocation() %></th>
			</tr>
		</table>
	</div>
   </div>
  <div class="footer">
  	
  </div>

</div>

</body>
</html>