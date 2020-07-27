<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Complaint</title>
</head>
<body background="/images/electricity1.jpg">
  <form action="registercomplaint" method="POST" modelAttribute="complaint">
     <h4>Please enter your complaint regarding billing below:</h4>
     <textarea rows="10" cols="100" id="complaintDesc" name="complaintDesc"></textarea>
     <input type="submit" value="submit">
  </form>
    <br><br><br>
  <form action="return">
    <input type="submit" value="User Home Page">
  </form>

</body>
</html>