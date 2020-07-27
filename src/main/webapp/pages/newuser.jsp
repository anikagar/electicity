<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel = "stylesheet"  type="text/css" href="/css/login.css">
</head>
<script type="text/javascript" >
function validateform(){
  var firstName=document.newuserform.firstName.value;
  var lastName=document.newuserform.lastName.value;
  var phonenum=document.newuserform.phoneNumber.value;
  
  if(firstName.length<3){
	  alert("First Name must be at least 3 characters long.");
	  return false;
  }
  if(isNaN(phonenum)){
	  alert("Phone Number should contains digits only.");
	  return false;
  } else {
	  return true;
  }
}
</script>
<body background="/images/electricity1.jpg">
   <form name="newuserform" onsubmit="return validateform()" action="registration" modelAttribute="newUser" method="POST">
      <br><br><br><br><br><br>
      <table>
        <tr>
          <th>First Name : </th>
          <td><input type="text"  id="firstName" name="firstName" required="required" pattern="[A-Za-z]{3,}" 
                     title="Should conntains alphabets starting with Capital letter and name should contains atleast 3 character"></td>
        </tr>
        <tr>
          <th>Last Name : </th>
          <td><input type="text" id="lastName" name="lastName" required="required"></td>
        </tr>
        <tr>
          <th>Email : </th>
          <td><input type="email" id="email" name="email" required="required"></td>
        </tr>
        <tr>
          <th>Address : </th>
          <td><input type="text" id="address" name="address"></td>
        </tr>
        <tr>
          <th>Phone Number : </th>
          <td><input type="text" id="phoneNumber" name="phoneNumber" required="required" pattern="[0-9]{10}" 
                     title="Should be of 10 digits">
          </td>
        </tr>
        <tr>
          <th>Username : </th>
          <td><input type="text" id="username" name="username" required="required" pattern=".{8}"
                     title="Should be of exact 8 characters"></td>
        </tr>
        <tr>
          <th>Password : </th>
          <td><input type="password" id="password" name="password" required="required"
                     pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$"
                     title ="Must contain at least one  number and one uppercase and lowercase letter,
                             and one special character and at least 8 but not more than 16 characters"></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" value="Save User"></td> 
        </tr>
      </table>
   </form>
   <br><br><br>
   <form action="home">
     <input type="submit" value="Home">
   </form>
</body>
</html>