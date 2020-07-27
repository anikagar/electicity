<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<body background="/images/electricity1.jpg">
   <form action="changepassword" method="post">
      <br><br><br><br><br><br>
      <table>
         <tr>
           <th> Username : </th>
           <td><input type="text" id="username" name="username" required="required"></td>
         </tr>
         <tr>
           <th> Password : </th>
           <td><input type="password" id="password" name="password" required="required"
                      pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$"
                      title ="Must contain at least one  number and one uppercase and lowercase letter,
                             and one special character and at least 8 but not more than 16 characters"></td>
         </tr>
         <tr>
          <td colspan="2"><input type="submit" value="Change Password"></td>
         </tr> 
      </table>
   </form>
   <br><br><br>
   <form action="home">
     <input type="submit" value="Home">
   </form>

</body>
</html>