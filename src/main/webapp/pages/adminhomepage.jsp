<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<body background="/images/electricity1.jpg">
  <form action="electricityadminoption">
  <h4>Choose the below option to work on : </h4>
  <table>
    <tr>
      <td><input type="radio" name="electricityadmin" value="billingrate"></td>
      <td align="left">Billing Rate</td>
    </tr>
    <tr>
      <td><input type="radio" name="electricityadmin" value="generatebill"></td>
      <td align="left">Generate Bill</td>
    </tr>
    <tr>
      <td><input type="radio" name="electricityadmin" value="viewcomplaint"></td>
      <td align="left">View Complaint</td>
    </tr>
    <tr>
      <td><input type="radio" name="electricityadmin" value="report"></td>
      <td align="left">Report</td>
    </tr>
    <tr>
      <td colspan="2"><input type = "submit" value="submit"></td>
    </tr> 
  </table>  
  </form>
  <br><br><br>
  <form action="home">
     <input type="submit" value="Home">
   </form>


</body>
</html>