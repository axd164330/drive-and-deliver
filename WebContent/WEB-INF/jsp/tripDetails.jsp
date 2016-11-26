<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip Details</title>
</head>
<body>

<a href="${contextPath}/">Back to Home</a>

<div align="center">

<h2>Trip Details</h2>

<table border="1">
	<tr>
		<th>Time For Trip</th>
		<th>Start Address</th>
		<th>End Address</th>
		<th>Car Details</th>
	</tr>
	<tr>
		<td>${tripDetails.timeOfTravel}</td>	
	
	<c:forEach var="addressList" items="${tripDetails.address}">
	
		<td>Street 1 : ${addressList.address1} <br/>
			Street 2 : ${addressList.address2} <br/>
			City : ${addressList.city} <br/>
			Phone number  : ${addressList.phoneNo} <br/>
			pin code : ${addressList.poBox} <br/>
	</td>
	
	</c:forEach>
	
		<td>
			Make : ${tripDetails.car.make} <br/>
			Model : ${tripDetails.car.model} <br/>
			Car Number : ${tripDetails.car.carNumber} <br/>
		</td>
	</tr>
</table>
<%-- 
TIME for trip : ${tripDetails.timeOfTravel}


<c:forEach var="addressList" items="${tripDetails.address}">
	<h4>${addressList.typeOfAddress} Address </h4>
	Street 1 : ${addressList.address1} <br/>
	Street 2 : ${addressList.address2} <br/>
	
	City : ${addressList.city} <br/>
	Phone number  : ${addressList.phoneNo} <br/>
	pin code : ${addressList.poBox} <br/>
	<br/>
</c:forEach>

<h4> Car Details </h4>
Make : ${tripDetails.car.make}
Model : ${tripDetails.car.model}
Car Number : ${tripDetails.car.carNumber}
 --%>

<div align="center">
<c:choose>
	<c:when test="${tripDetails.myPackage2 eq null}">
		we are assigning drivers
	</c:when>
	<c:otherwise>
		
		<h3>Details of Package to be picked</h3>
		
		<table border="1">
			<tr>
				<th>Name:</th>
				<th>Start Address</th>
				<th>End Address</th>
				
			</tr>
			<tr>
				<td>Name: ${tripDetails.myPackage2.user.name}</td>
				<c:forEach var="addressList" items="${tripDetails.myPackage2.address}">
				<td>Street 1 : ${addressList.address1} <br/>
					Street 2 : ${addressList.address2} <br/>
					City : ${addressList.city} <br/>
					Phone number  : ${addressList.phoneNo} <br/>
					pin code : ${addressList.poBox} <br/>
				</td>
				</c:forEach>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
</div>
</div>
</body>
</html>