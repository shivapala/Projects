 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.*"  import="com.entity.flyaway.model.*" language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ include file="/pages/html/Header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
 <sql:setDataSource
        var="fly"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/flyaway"
        user="root" password="Admin123"
    />
    <sql:query dataSource="${fly}" var="listLocations">
    	select * from locations; 
    </sql:query>
    
 <form action="/FlyAwayApp/FlightResults" method="post">

 From : 
<select name="srcLocation">
    <c:forEach var="location" items="${listLocations.rows}">
        <option value=<c:out value="${location.id}"></c:out>><c:out value="${location.Location_NM}"></c:out></option>
    </c:forEach>
</select>
To : 
<select name="DestLocation">
    <c:forEach var="location" items="${listLocations.rows}">
        <option value=<c:out value="${location.id}"></c:out>><c:out value="${location.Location_NM}"></c:out></option>
    </c:forEach>
</select>
  <label for="bookDate">Date :</label>
  <input type="date" id="bookDate" name="bookDate">
  <input type="submit">
</form>

</body>
</html>


 
 <%@ include file="/pages/html/footer.html" %>
