<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body background="/images/electricity1.jpg">
 <form action="reportrequest">
   <table align="center">
    <tr>
      <td align="center">Report Type :</td>
      <td>
        <select name="reportType" id="reportType" required="required">
           <option value="PR">Payment Received</option>
           <option value="PP">Payment Pending</option>
        </select>
      </td>
     </tr>
     <tr>
       <td align="center">Bill Month :</td>
       <td><input type="date" name="billMonth" id="billMonth" required="required"></td>
     </tr>
     <tr>
       <td colspan="2" align="center"><input type="submit" name="submit"></td>
     </tr>
   </table> 
 </form>
 <br><br><br>
 <form>
  <c:if test="${not empty reportList}">
   <table align="center" border="1">
      <tr align="center">
         <th align="center">Bill Month</th>
         <th align="center">Username</th>
         <th align="center">Amount</th>
      </tr>
      <c:forEach var="list" items="${reportList}">
         <tr align="center">
           <td align="center"><c:out value="${list.billMonth}"></c:out></td>
           <td align="center"><c:out value="${list.username}"></c:out></td>
           <td align="center"><c:out value="${list.totalPrice}"></c:out></td>
         </tr>
      </c:forEach>      
   </table>
  </c:if>
 </form>
 <br><br><br>
 <form action="return">
   <input type="submit" value="Admin Home Page">
 </form>

</body>
</html>