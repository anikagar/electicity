<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<body background="/images/electricity1.jpg">
  <form action="login">
     <br><br><br><br><br><br><br><br>
     USERNAME : <input type="text" id="username" name="username">
     PASSWORD : <input type="password" id="password" name="password">
     <input type="submit" value="Login">
  </form>
  <p><a href="/electricity/forgotpassword">Forgot Password</a></p>
  <p><a href="/electricity/newuser">New User</a><p> 
</body>
</html>