<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pentagon.studentDTO.Student" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update_password</title>
</head>
<body>
<% Student s = (Student)session.getAttribute("student");%>
<form action="updatepassword" method="post">
old password:<input type="password" name="oldpassword" >
new password:<input type="password" name="newpassword" >
confirm password:<input type="password" name="confirmpassword" >
<button>update</button>
</form>

</body>
</html>