 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.util.*"  import="com.entity.flyaway.model.*" language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
   
    <%@ include file="/pages/html/AdminHeader.html" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
* {box-sizing: border-box}
body {font-family: "Lato", sans-serif;}
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
.center {
  margin-left: auto;
  margin-right: auto;
}
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 40px 40px;
  font-size: 20px;
  cursor: pointer;
 
}
/* Darker background on mouse-over */
.btn:hover {
  background-color: RoyalBlue;
}
/* Style the tab */
.tab {
  float: left;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  width: 30%;
  height: 300px;
}

/* Style the buttons inside the tab */
.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  float: left;
  padding: 0px 12px;
  border: 1px solid #ccc;
  width:60%;
  border-left: none;
  height: 60%;
}
</style>
</head>
<body>
 <sql:setDataSource
        var="fly"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/flyaway"
        user="root" password="Admin123"
    />
    <sql:query dataSource="${fly}" var="listAirLines">
    	select * from airlines; 
    </sql:query>
     <sql:query dataSource="${fly}" var="listFlights">
    	select  Flight_Id,FlghtNbr,ar.AirLines_NM as AirName,Occupancy,Flight_Typ,src.location_NM as Source,
src.code_nm as srcCode,dest.location_NM as Dest,src.code_nm as DestCode,price
from flightlist flght
inner join airlines ar on flght.Air_id=ar.id
left join locations src on src.id=flght.src_id
left join locations dest on dest.id=flght.dest_id;
    </sql:query>
     <sql:query dataSource="${fly}" var="listLocations">
    	select * from locations; 
    </sql:query>
<h1 style="text-align: center" ><b>Employee Portal</b> </h1>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Airlines')" id="defaultOpen">Airlines</button>
  <button class="tablinks" onclick="openCity(event, 'AirFlights')">AirFlights</button>
  <button class="tablinks" onclick="openCity(event, 'Locations')">Locations</button>
</div>

<div id="Airlines" class="tabcontent">
  <h3>List of AirLines</h3>
  <div style="overflow-x:auto;">
 <table class="center">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>FlightCnt</th>
    <th>created</th>
  </tr>
  <c:forEach var="Air" items="${listAirLines.rows}">
  <tr>
  <td><c:out value="${Air.id}"></c:out> </td>
  <td><c:out value="${Air.AirLines_NM}"></c:out> </td>
  <td><c:out value="${Air.Flight_cnt}"></c:out> </td>
  <td><c:out value="${Air.created}"></c:out> </td>
  </tr>
  </c:forEach>
 </table>
 </div>
</div>

<div id="AirFlights" class="tabcontent">
  <p>Flights Available for booking through AirwayApp</p>
 <div style="overflow-x:auto;">
 <table class="center">
  <tr>
    <th>Flight_Id</th>
    <th>FlghtNbr</th>
    <th>AirName</th>
    <th>Occupancy</th>
    <th>Source</th>
    <th>SrcCode</th>
     <th>Dest</th>
      <th>DestCode</th>
       <th>price</th>
  </tr>
  <c:forEach var="AirFlights" items="${listFlights.rows}">
  <tr>
  <td><c:out value="${AirFlights.Flight_Id}"></c:out> </td>
  <td><c:out value="${AirFlights.FlghtNbr}"></c:out></td>
  <td><c:out value="${AirFlights.AirName}"></c:out></td>
  <td><c:out value="${AirFlights.Occupancy}"></c:out> </td>
  <td><c:out value="${AirFlights.Flight_Typ}"></c:out></td>
   <td><c:out value="${AirFlights.Source}"></c:out></td>
    <td><c:out value="${AirFlights.SrcCode}"></c:out></td>
   <td><c:out value="${AirFlights.Dest}"></c:out></td>
   <td><c:out value="${AirFlights.DestCode}"></c:out></td>
   <td><c:out value="${AirFlights.price}"></c:out></td>
  </tr>
  </c:forEach>
  </table>
 </div>
</div>

<div id="Locations" class="tabcontent">
  <p>List of Locations<p>
<div style="overflow-x:auto;">
 <table class="center">
  <tr>
    <th>Id</th>
    <th>City</th>
    <th>Country</th>
    <th>code</th>
    <th>created</th>
  </tr>
  <c:forEach var="location" items="${listLocations.rows}">
  <tr>
  <td><c:out value="${location.id}"></c:out> </td>
  <td><c:out value="${location.Location_NM}"></c:out></td>
  <td><c:out value="${location.country}"></c:out></td>
  <td><c:out value="${location.code_nm}"></c:out> </td>
  <td><c:out value="${location.created}"></c:out></td>
  </tr>
  </c:forEach>
  </table>
 </div>
</div>

<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
  
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


</script>
 
</body>
</html>
 
 
 <%@ include file="/pages/html/footer.html" %>
