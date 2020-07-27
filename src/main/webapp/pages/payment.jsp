<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
</head>
<body background="/images/electricity1.jpg">
   <div>  
    <form action="paymentdetail">
    <table>
      <tr>
        <th align="center">Choose the Bill Month for Payment</th>
      </tr>
      <tr>
        <td align="center">
          <select name="billMonth" id="billMonth">
            <c:forEach var="bmlist" items="${billMonthList}">
               <option value="${bmlist}">${bmlist}</option>
            </c:forEach>
          </select> 
        </td>
      </tr>
      <tr>
        <td align="center">
           <input type="submit" value="submit">
        </td>
      </tr>
    </table>
    </form>
  </div>
  <br><br>
  <div>
    <form action="payment" modelAttribute="payment" method="post">
     <c:if test="${not empty billDetail}">
      <table border="1">
         <tr>
           <th>Bill Month</th>
           <td><input type="text" id="billMonth" name="billMonth" value="${billDetail.billMonth}" readonly="readonly"></td>
         </tr>
         <tr>
           <th>Total Price</th>
           <td><input type="text" id="totalPrice" name="totalPrice" value="${billDetail.totalPrice}" readonly="readonly"></td>
         </tr>
         <tr>
           <th>Payment Amount</th>
           <td><input type="text" id="paymentAmount" name="paymentAmount" value="${billDetail.totalPrice}" readonly="readonly"></td>
         </tr>
         <tr>
           <td colspan="2" align="center"><input type="submit" value="payment"></td>
         </tr>  
      </table>
     </c:if>
    </form>   
  </div>
  <br><br><br>
  <div>
    <form action="return">
      <input type="submit" value="User Home Page">
    </form>
  </div>
</body>
</html>