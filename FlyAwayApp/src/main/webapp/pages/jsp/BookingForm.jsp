
<%@ page import="java.util.*"  import="com.entity.flyaway.model.*" language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
     <%@ include file="/pages/html/Header.html" %>
    <%
String hd= request.getParameter("flight");
  System.out.println("The airFlight Object"+hd);
  
 int index= Integer.parseInt(hd);
  List<AirFlights> flights=(List<AirFlights>) session.getAttribute("listFlights");
  System.out.println("The airFlight Object"+flights.size());
 %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}
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
.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

.input {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn1 {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 10px;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn1:hover {
  background-color: #45a049;
}


a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
}

</style>
</head>
<body>
<form>
<div class="container">
<div class="panel panel-success">
  <div class="panel-heading">
  <b>Flight Details</b><br>
  <label for="fId">Flight Id :</label><input type="text" id="fId" name="fId" disabled="disabled" value=<%= flights.get(index).getFlight_Id() %>>
   <label for="fNbr">Flight Nbr :</label><input type="text" id="fNbr" name="fNbr" disabled="disabled" value=<%= flights.get(index).getFlightNbr() %>>
  <label for="fPrice">Price per Person :</label><input type="text" id="fPrice" disabled="disabled" name="fPrice" value=<%= flights.get(index).getPrice() %>>
   <label for="fSource">source :</label><input type="text" id="fSource" name="fSource" disabled="disabled" value=<%= flights.get(index).getSource().getLocName() %>>
    <label for="fDest">Dest :</label><input type="text" id="fDest" name="fDest" disabled="disabled" value=<%= flights.get(index).getDest().getLocName() %>>
      <label for="fAirLine">AirLine Name :</label><input type="text" id="fAirLine" name="fAirLine" disabled="disabled" value=<%= flights.get(index).getAirLine().getAirLineName() %>>
        <label for="fbkdDate">Reservation :</label><input type="text" id="fbkdDate" name="fbkdDate" disabled="disabled" value=<%= flights.get(index).getAvail().getAvl_date() %>>
  
  </div>
   <div class="panel-body"> 
   <h2>Enter Reservation Details</h2><br>
     <label for="TAdult">Adults :</label><input type="number" id="TAdult" name="TAdult" value="0" style="width: 40px;"> <br>	
   <label for="TChild">Minor(Age : 2-11) :</label><input type="number" id="TChild" name="TChild" value="0"  style="width: 40px;"><br>
     <label for="TnewBorn">New Born :</label><input type="number" id="TnewBorn" name="TnewBorn" style="width: 40px;"><br>
   
   <label for="Tnbr">TotalTickets :</label><input type="number" id="Tnbr" name="Tnbr"  style="width: 70px;" onclick="total()">
   <div class="input-group">
      <span class="input-group-addon">Notes</span>
      <input id="Notes" type="text" class="form-control" name="Notes" placeholder="Additional Info">
    </div>
   </div>
  </div>

</form>
<div class="panel-body"> 
<div class="col-50">
<h3>Payment Details</h3>
           <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input class="text" type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label  for="ccnum">Credit card number</label>
            <input class="text" type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
            <label for="expmonth">Exp Month</label>
            <input class="text" type="text" id="expmonth" name="expmonth" placeholder="September">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input class="text" type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-50">
                <label  for="cvv">CVV</label>
                <input class="text" type="text" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          </div>
             
        <label >
          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing</label>
        <input type="submit" value="checkout" class="btn1" onclick="add()">
   </div>
    </div>
   
  <script>
  function add()
  {
	
	 confirm("Thank you for the Payment !! submit to confirm ");
	  
     
  }
  
  function total()
  {
	   
		  var ta=document.getElementById("TAdult").value; 
		  var tb=document.getElementById("TChild").value; 
		  var tc=document.getElementById("TnewBorn").value; 
		 document.getElementById("Tnbr").value=parseInt(ta)+parseInt(tb)+parseInt(tc);
		 
		  
  }
     </script>
</body>
</html>
 
 <%@ include file="/pages/html/footer.html" %>
 
