<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getAttribute("pass")!=null) { %>
<%=request.getAttribute("pass")%>
<% } %>
<%if(request.getAttribute("fail")!=null) { %>
<%=request.getAttribute("fail")%>
<% } %>


<form action="forget" method="post">
Email:<input type="email" name="email" placeholder="Enter the Email you registred with">
Phone:<input type="tel"  name="phone" placeholder="Enter the phone number">
New Password:<input type="password"  name="password" placeholder="Enter the password">
Confirm Password:<input type="password"  name="confirmpassword" placeholder="RE-Enter the password">
<button>Submit</button>

</form>

</body>
</html>