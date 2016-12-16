<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip Details</title>
</head>
<body>

<a href="${contextPath}/">Back to Home</a>

<div align="center">

<h2>Package Details</h2>


<table border="1">
	<tr>
		<th>Time For Pickup</th>
		<th>Start Address</th>
		<th>End Address</th>
		<th>Package Dimensions</th>
	</tr>
	<tr>
		<td>${packageDetails.pickupDate}</td>	
	
	<c:forEach var="addressList" items="${packageDetails.address}">
	
		<td>Street 1 : ${addressList.address1} <br/>
			Street 2 : ${addressList.address2} <br/>
			City : ${addressList.city} <br/>
			Phone number  : ${addressList.phoneNo} <br/>
			pin code : ${addressList.poBox} <br/>
	</td>
	
	</c:forEach>
	
		<td>
			Length : ${packageDetails.length} <br/>
			Width : ${packageDetails.width}	<br/>
			Height : ${packageDetails.height} <br/>
		</td>
	</tr>
</table>

<%-- Date for trip : ${packageDetails.pickupDate}


<c:forEach var="addressList" items="${packageDetails.address}">
	<h4>${addressList.typeOfAddress} Address </h4>
	Street 1 : ${addressList.address1} <br/>
	Street 2 : ${addressList.address2} <br/>
	
	City : ${addressList.city} <br/>
	Phone number  : ${addressList.phoneNo} <br/>
	pin code : ${addressList.poBox} <br/>
	<br/>
</c:forEach>

<h3> Dimensions Details </h3>
Length : ${packageDetails.length}
Width : ${packageDetails.width}
Height : ${packageDetails.height} --%>

</div>

<div align="center">
<h3>Details of Driver who will pickup this package</h3>
<c:choose>
	<c:when test="${packageDetails.tripId eq null}">
		we are assigning drivers
	</c:when>
	<c:otherwise>
		
		
		
		<table border="1">
			<tr>
				<th>Name:</th>
				<th>Start Address</th>
				<th>End Address</th>
				<th>Car Details</th>
			</tr>
			<tr>
				<td>Name: ${packageDetails.tripId.user.name}</td>
				<c:forEach var="addressList" items="${packageDetails.tripId.address}">
				<td>Street 1 : ${addressList.address1} <br/>
					Street 2 : ${addressList.address2} <br/>
					City : ${addressList.city} <br/>
					Phone number  : ${addressList.phoneNo} <br/>
					pin code : ${addressList.poBox} <br/>
				</td>
				</c:forEach>
				<td>Make : ${packageDetails.tripId.car.make} <br/>
					Model : ${packageDetails.tripId.car.model} <br/>
					Car Number : ${packageDetails.tripId.car.carNumber} <br/></td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
</div>


</body>
</html>