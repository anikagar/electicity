<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link rel = "stylesheet"  type="text/css" href="/css/error.css">
</head>
<body>
  <c:if test="${not empty message}">
  <img alt="error image" src="/images/error.jpg"><br>
  <h3> you have below error :</h3>
  <br/>
  <h2><c:out value="${message}"></c:out> </h2>
  <br/>
  <h3>Please rectify the issue or contact the admin</h3>  
  </c:if>
  <br><br><br>
  <form action="home">
     <input type="submit" value="Home">
   </form>

</body>
</html>