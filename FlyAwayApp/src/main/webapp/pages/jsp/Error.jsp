<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/pages/html/Header.html" %>
    <%
 String msg=(String) session.getAttribute("ErrorMsg");
 %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Error Page</title>
</head>
<body>
Error Message : <h2 style="color:red"> <%=msg %> </h2>
<h2>start over </h2><a href="/pages/html/MainPage.html"><b>Home Page</b></a>
</body>
</html>
 
 <%@ include file="/pages/html/footer.html" %>
 
