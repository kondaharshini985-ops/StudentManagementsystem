<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login form</title>
</head>
<body>
<% if(session.getAttribute("success")!=null) {%>
<%=session.getAttribute("success") %>
<% }%>
<% if(session.getAttribute("fail")!=null) {%>
<%=session.getAttribute("fail") %>
<% }%>

<h1 style="text-align:center;">LOGIN PAGE</h1>
<hr color="black">
<fieldset>
<legend>login</legend>
<form width="200" height="200"  action="login" method="post">
username:<br>
<input type="email" name="email" placeholder="Enter email" required><br>
password:<br>
<input type="password" name="password" placeholder="Enter password" required><br>
<a href="forgetpassword.jsp" target="_blank">Forget password</a><br>
<input type="submit" value="login">
<p>Don't have an account <a href="signup.jsp">click here</a>
</form>
</fieldset>

</body>
</html>
    