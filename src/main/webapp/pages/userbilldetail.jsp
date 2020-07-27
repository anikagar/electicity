<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Bill Detail</title>
</head>
<body background="/images/electricity1.jpg">
  <c:if test="${not empty billList}">
     <div>
       <h2>${username} Bill Detail :</h2>
     </div>
     <br>
     <div>
       <c:forEach var="bill" items="${billList}">
          <h4>Bill Month : <c:out value="${bill.billMonth}"></c:out></h4>
          <table border="1">
             <tr>
               <td>Previous reading</td>
               <td><c:out value="${bill.previousReading }"></c:out></td>
             </tr>
             <tr>
               <td>Current reading</td>
               <td><c:out value="${bill.currentReading }"></c:out></td>
             </tr>
             <tr>
               <td>Unit Consumed</td>
               <td><c:out value="${bill.unitConsumed }"></c:out></td>
             </tr>
             <tr>
               <td>Per Unit Price</td>
               <td><c:out value="${bill.pricePerUnit }"></c:out></td>
             </tr>
             <tr>
               <td>Total Price</td>
               <td><c:out value="${bill.totalPrice }"></c:out></td>
             </tr>
             <tr>
               <td>Bill Type</td>
               <td><c:out value="${bill.billType }"></c:out></td>
             </tr>
             <tr>
               <td>Billing Date</td>
               <td><c:out value="${bill.billingDate }"></c:out></td>
             </tr>
             <tr>
               <td>Due Date</td>
               <td><c:out value="${bill.dueDate }"></c:out></td>
             </tr>
          </table>
       </c:forEach>
    </div>   
  </c:if>

</body>
</html>