<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<body background="/images/electricity1.jpg">
  <form action="electricityuseroption">
  <h4>Choose the below option to work on</h4>
  <br>
  <table>
     <tr>
       <td><input type="radio" name="electricityuser" value="fetchbill"/></td>
       <td align="left">Fetch Bill</td>
     </tr>
     <tr>
       <td><input type ="radio" name="electricityuser" value="registercomplaint"/></td>
       <td align="left">Register Complaint</td>
     </tr>
     <tr>
       <td><input type="radio" name="electricityuser" value="complaintresult"/></td>
       <td align="left">View Complaint Result</td>
     </tr>
     <tr>
       <td><input type="radio" name="electricityuser" value="payment"></td>
       <td align="left">Payment</td>
     </tr>
     <tr>
       <td colspan="2"><input type="submit" value="submit">
       </td>
     </tr>
  </table>
  </form>
  <br><br><br>
  <form action="home">
     <input type="submit" value="Home"/>
  </form>
</body>
</html>