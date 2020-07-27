<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BillingRate</title>
</head>
<body background="/images/electricity1.jpg">
   <table border="1">
     <tr>
       <th><b>Price per unit</b></th>
       <th><b>Due Days</b></th>
       <th><b>Current Indicator</b></th>
     </tr>
     <c:if test="${not empty billingratelist}">
        <c:forEach var="brlist" items = "${billingratelist}">
          <tr>
            <td><c:out value="${brlist.pricePerUnit}"></c:out></td>
            <td><c:out value="${brlist.dueDays}"></c:out></td>
            <td><c:out value="${brlist.currentInd}"></c:out></td>
          </tr>
        </c:forEach>
     </c:if>
   </table>
   
   <br><br><br>
   <form action = "addbillingratedetailform">
     <input type="submit" value="Add">
   </form>
   
   <br><br><br>
   
   <form action="return">
     <input type="submit" value="Admin Home Page">
   </form>
   

</body>
</html>