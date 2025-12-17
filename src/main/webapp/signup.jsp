<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>

    <style>
        body {
            background-color: white;
            margin:0;
        }

        input {
            margin: 10px;
        }

        form {
            text-align: center;
        }

        button {
            background-color: lightblue;
            padding: 5px 15px;
        }
        .fieldset{
        max-width:50px;
        margin:auto;
        margin-top:10px; 
        }
        .legend{
        color:black;
        }
        .header{
        height:50px;
        background-color:black;
        color:white;
        text-align:center;
        padding:5px;
        }
        .footer{
        height:50px;
        background-color:black;
        margin-top:220px;
        }
    </style>
</head>

<body>
<% if(request.getAttribute("fail")!= null){ %>
<%=request.getAttribute("fail") %>
<%} %>

<header class="header">
 SIGNUP PAGE
</header>
    <fieldset class="fieldset">
        <legend class="legend">Signup Page</legend>

        <!-- Action must match @WebServlet("/signup") -->
        <form action="signup" method="post">

            <input type="text" name="name" placeholder="Enter your name" required><br>

            <input type="tel" name="phone" placeholder="Enter the phone number" required><br>

            <input type="email" name="email" placeholder="Enter your email" required><br>

            <select name="branch" required>
                <option value="">Select Branch</option>
                <option value="Civil">Civil</option>
                <option value="Mech">Mech</option>
                <option value="ECE">ECE</option>
                <option value="CSE">CSE</option>
                <option value="IT">IT</option>
            </select>

            <select name="location" required>
                <option value="">Select Location</option>
                <option value="Hyderabad">Hyderabad</option>
                <option value="Bengalore">Bengalore</option>
                <option value="Chennai">Chennai</option>
                <option value="Mumbai">Mumbai</option>
            </select>
            <br>

            <input type="password" name="password" placeholder="Enter the password" required><br>

            <input type="password" name="confirmpassword" placeholder="Re-enter the password" required><br>

            <button type="submit">Signup</button>
            <a href="login.jsp">Already have an account</a>

        </form>
    </fieldset>
    <footer class="footer">
    </footer>
</body>
</html>
    