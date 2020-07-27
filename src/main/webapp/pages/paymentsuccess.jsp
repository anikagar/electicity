<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Success</title>
</head>
<body background="/images/electricity1.jpg">
  <h3>Your Payment is success. below is the payment receipt:</h3>
  <table border="1">
    <c:if test="${not empty paydetail}">
      <tr>
        <th align="left">Username</th>
        <td align="left">${paydetail.username}</td>
      </tr>
      <tr>
        <th align="left">Transaction Id</th>
        <td align="left">${paydetail.transactionId}</td>
      </tr>
      <tr>
        <th align="left">Bill Month</th>
        <td align="left">${paydetail.billMonth}</td>
      </tr>
      <tr>
        <th align="left">Total Price</th>
        <td align="left">${paydetail.totalPrice}</td>
      </tr>
      <tr>
        <th align="left">Payment Amount</th>
        <td align="left">${paydetail.paymentAmount}</td>
      </tr>
      <tr>
        <th align="left">Payment Date</th>
        <td align="left">${paydetail.paymentDate}</td>
      </tr>
    </c:if>
  </table>
  <br><br><br>
  <form action="return">
      <input type="submit" value="User Home Page">
    </form>
  

</body>
</html>