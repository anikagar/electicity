<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complaint result</title>
</head>
<body background="/images/electricity1.jpg">
 <form action="updatecomplaintfromuser" modelAttribute="complaint" method="post">
   <table border="1">
     <tr>
       <th>Complaint Id</th>
       <th>Complaint Desc</th>
       <th>Complaint Reply</th>
       <th>Complaint Status</th>
       <th>Complaint New Status</th>
       <th></th>
     </tr>
     <c:forEach var="result" items="${resultList}">
       <tr>
         <td><input type="text" id="complaintId" name="complaintId" value="${result.complaintId}" readonly="readonly"></td>
         <td><input type="text" id="complaintDesc" name="complaintDesc" value="${result.complaintDesc}" ></td>
         <td><input type="text" id="complaintReply" name="complaintReply" value="${result.complaintReply}" readonly="readonly"></td>
         <td><c:out value="${result.complaintStatus}"></c:out></td>
         <td><select name="complaintStatus" id="complaintStatus" required="required">
                <option value="NEW">NEW</option>
                <option value="USER RESOLVED">USER RESOLVED</option>
             </select>
         </td>
         <td><input type="submit" value="submit"/></td>
       </tr> 	
     </c:forEach> 
   </table>
 </form>
 <br><br><br>
 <form action="return">
    <input type="submit" value="User Home Page">
 </form>

</body>
</html>