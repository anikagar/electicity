<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Complaint</title>
</head>
<body background="/images/electricity1.jpg">
   <form action="complaintresolution" modelAttribute="complaint" method="post">
       <table border="1">
       <tr>
        <th>Complaint Id</th>
        <th>Username</th>
        <th>Complaint Desc</th>
        <th>Complaint Status</th>
        <th>Complaint Reply</th>
        <th>Complaint New Status</th>
        <th></th>
       </tr>
       <c:forEach var="comp" items= "${complaintList}">
         <tr>
           <td><input type="text" id="complaintId" name="complaintId" value="${comp.complaintId}" readonly="readonly">
           <td><input type="text" id="username" name="username" value="${comp.username}" readonly="readonly">
           <td><input type="text" id="complaintDesc" name="complaintDesc" value="${comp.complaintDesc}" ></td>
           <td><c:out value="${comp.complaintStatus}"></c:out></td>
           <td><input type="text" id="complaintReply" name="complaintReply"></td>
           <td><select name="complaintStatus" id="complaintStatus" required="required">
                  <option value="IN PROGRESS">IN PROGRESS</option>
                  <option value="RESOLVED">RESOLVED</option>
               </select></td>
           <td><input type="submit" value="submit"></td>
         </tr>
       </c:forEach>        
       </table>
    </form> 
    <br><br><br>
    <form action="return">
       <input type="submit" value="Admin Home Page"/>
    </form>
</body>
</html>