<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Bill</title>
</head>
<body background="/images/electricity1.jpg">
   <form action="generatebill" modelAttribute="billingdetail" method="post">
      <table>
         <tr>
           <th>Current Reading : </th>
           <td><input type="text" id="currentReading" name= "currentReading" required="required" pattern="[0-9]{2,}"
                      title="there should be atleast 2 digit"></td>
         </tr>
         <tr>
           <th>Bill Month : </th>
           <td><input type="text" id="billMonth" name="billMonth" required="required" pattern="[A-Za-z]{3}[-][2][0][0-9]{2}"
                      title="Pattern should be like Jan-2020"></td>
         </tr>
         <tr>
           <th>Bill Type : </th>
           <td>
              <select name="billType" id="billType" required="required">
                  <option value="Original">Original</option>
                  <option value="Corrected">Corrected</option>
              </select> 
           </td>
         </tr> 
         <tr>
           <th>Username : </th>
           <td>
              <select name="username" id="username" required="required">
                 <c:forEach var="name" items="${usernameList}">
                    <option value="${name}">${name}</option>
                 </c:forEach> 
              </select>
           </td>
         </tr>       
         <tr>
           <td colspan="2">
             <input type="submit" value="Generate Billing">
           </td>
         </tr>
      </table>
   </form>
   <br><br><br><br>
  <form action="return">
     <input type="submit" value="Admin Home Page">
   </form>
</body>
</html>