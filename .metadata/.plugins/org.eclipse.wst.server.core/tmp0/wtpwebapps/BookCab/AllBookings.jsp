<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OnlineCabBooking</title>
</head>
<style>
	body{
	
		background : linear-gradient(45deg,#FC466B,#3F5EFB);
		height : 100vh;
		font-family : "Montserrat", sans-serif;
	}
	form {
		font-family : "Montserrat", sans-serif;
		background : rgba(255,255,255,0.3);
		padding : 5em;
		height : 320px;
		border-radius : 20px;
		border-left : 1px solid rgba(255,255,255,0.3);
		border-top : 10px solid rgba(255,255,255,0.3);
		background-filter : blur(10px);
		box-shadow : 20px 20px 40px -6px rgba(0, 0, 0, 0.2);
		text-align : center;
		position : relative;
		transition : all 0.2 ease-in-out;
		margin-right : 100px;
	}
	input {
		border-radius : 20px;
		box-shadow : 20px 20px 40px -6px rgba(0, 0, 0, 0.2);
		padding  : 10px 50px;
		margin-top : 20px;
		background-filter : blur(10px);
	}
	.but{
		padding-left : 0px;
	}
	.alignment{
		text-align : center;		
		border-radius : 10px;		
		padding: 10px;
	}
	ul {
  		list-style-type: none;  		
  		overflow: hidden;  		
	}

	li {
  		float: left;
	}

	li a {
  		display: block;
  		color : black;
  		text-align: center;
  		padding: 14px 30px;
  		text-decoration: none;
  		font-size : 20px;
	}

	li a:hover:not(.active) {
  		background-color: #111;
  		border-radius : 10px;
  		color : white;	
	}	
	.h{
		padding : 100px;	
	}
	.left{
		float : left;
		font-size : 30px;
	}
	.right{
		float : right;
	}
	.para{
		padding-left : 120px;
		font-family : "Montserrat", sans-serif;
		font-size : 20px;		
	}
	.over:hover:not(.active) {
  		background-color: #111;
  		border-radius : 10px;
  		color : white;	
	}	
</style>
<body>
<div class = "alignment">
	<h1 >OnlineCabBookingSystem</h1>
	<ul>
		<li><a href = "./Home.html">Home</a></li>
		<li><a href = "./SearchCab.html">Search Cabs</a></li>
		<li><a href = "./allbookings">All Bookings</a></li>	
		<li><a href = "./deleteCab.html">Delete Cab</a></li>
		<li><a href = "./changePassword.html">Change Password</a></li>
		<li><a href = "./logout">Logout</a></li>	
			
	</ul>
</div>

<div >
	
	<div class = "left">
		<h1>OurMotto</h1>
		<p>We give customer satisfaction the utmost priority and so give<br> ample options
		to book cab by entering details like their journey date and time, <br>pickup and
		the destination they need to reach.
		</p>
	</div>
	<div class = "right">
	
	</div>
</div>

<div>
	<c:choose>
	
	
		<c:when test="${bookedCabs ne null || !empty bookedCabs }">
	<table border = '1'>
	<tr>
	<th>User Name</th>
	<th>User Email</th>
	<th>User DOB</th>
	<th>User Gender</th>
	<th>User Address</th>
	<th>User Number</th>
	<th>Car Number</th>
	<th>Driver Name</th>
	<th>Car Colour</th>
	<th>From Address</th>
	<th>To Address</th>
	<th>Car Type</th>
	<th>Driver Number</th>
	<th>Booking Date</th>
	<th>Booking Time</th>
	<th>Canceled</th>
	</tr>
		<c:forEach var = "cab" items = "${bookedCabs }">
			<tr>
				<td>${cab.userName}</td>
				<td>${cab.email }</td>
				<td>${cab.DOB }</td>
				<td>${cab.gender }</td>
				<td>${cab.address }</td>
				<td>${cab.userNumber }</td>
				<td>${cab.carNumber}</td>
				<td>${cab.driverName}</td>
				<td>${cab.carColour}</td>
				<td>${cab.fromAddress}</td>
				<td>${cab.toAddress}</td>
				<td>${cab.carType }</td>
				<td>${cab.driverNumber }</td>
				<td>${cab.date }</td>
				<td>${cab.time}</td>
				<td>${cab.cancel }</td>
			</tr>
		</c:forEach>
		</table>
		</c:when>
		<c:otherwise>
		<h1>No cabs Boooked</h1>
		</c:otherwise>
	</c:choose>
	
</div>
</body>
</html>