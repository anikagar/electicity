<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing Rate Form</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<body background="/images/electricity1.jpg">
  <form action="addbillingratedetail" modelAttribute="billingrate" method="POST">
      <table>
        <br><br><br><br><br>
        <tr>
          <th>Per Unit Price : </th>
          <td><input type="text" id="pricePerUnit" name="pricePerUnit" required="required" pattern="[0-9]{1,3}[.][0-9]{2}"></td>
        </tr>
        <tr>
          <th>Due Days : </th>
          <td><input type="text" id="dueDays" name = "dueDays" required="required" pattern="[0-9]{1,}"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="add"></td>
        </tr> 
      </table>
  </form>
  <br><br><br><br>
  <form action="return">
     <input type="submit" value="Admin Home Page">
   </form>
</body>
</html>