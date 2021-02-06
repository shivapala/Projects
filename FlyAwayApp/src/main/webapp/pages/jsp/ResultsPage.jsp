
<%@ page import="java.util.*"  import="com.entity.flyaway.model.*" language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
     <%@ include file="/pages/html/Header.html" %>
    <%
 List<AirFlights> flights=(List<AirFlights>) session.getAttribute("listFlights");
 %>
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
  padding: 10px 10px;
  font-size: 10px;
  cursor: pointer;
 
}
/* Darker background on mouse-over */
.btn:hover {
  background-color: RoyalBlue;
}

</style>
</head>
<body>

<div style="overflow-x:auto;">
 <table class="center">
  <tr>
    <th>Flight_Id</th>
    <th>FlghtNbr</th>
    <th>AirName</th>
     <th>Tickets Available</th>
    <th>Source</th>
    <th>SrcCode</th>
     <th>Dest</th>
      <th>DestCode</th>
       <th>price</th>
       <th>Date of Availablity</th>
  </tr>
 
  
<%
System.out.println(" Size of Flights : "+flights);
    for(int i=0; i<flights.size();i++){%>
    <%System.out.println("Inside For loop "+i+" object : "+flights.get(i).getFlight_Id()); %>
        <tr>
         <td><%= flights.get(i).getFlight_Id() %></td>
            <td><%= flights.get(i).getFlightNbr() %></td>
             <td><%= flights.get(i).getAirLine().getAirLineName() %></td>
              <td><%= flights.get(i).getAvail().getAvl_cnt() %></td>
             <td><%= flights.get(i).getSource().getLocName() %></td>
              <td><%= flights.get(i).getSource().getCodeNM() %></td>
               <td><%= flights.get(i).getDest().getLocName() %></td>
              <td><%= flights.get(i).getDest().getCodeNM() %></td>
              <td><%= flights.get(i).getPrice() %></td>
              <td><%= flights.get(i).getAvail().getAvl_date()%></td>
              <td><a href="pages/jsp/BookingForm.jsp?flight=<%=i%>">  <button class="btn"><i class="fa fa-home"></i> book</button></a></td>
        </tr>
      <%}%>
  </table>
 </div>
</body>
</html>
 
 
 <%@ include file="/pages/html/footer.html" %>
 
