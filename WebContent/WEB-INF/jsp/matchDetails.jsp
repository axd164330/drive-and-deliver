<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Match Details</title>
</head>
<body>

<a href="${contextPath}/">Back to Home</a>

<div align="center">


<c:choose>
	<c:when test="${message ne 'matchFound'}">
		
		<table>
			<tr>
				<td>We will get back to you shortly</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		
		<h3>Following is the driver details</h3>
		
		<table>
			<tr>
				<td>Driver Name</td>
				<td>${driver.name}</td>
			</tr>
			<tr>
				<td>Date of Pickup</td>
				<td>${tripDetails.timeOfTravel}</td>
			</tr>
			<tr>
				<td>Car Make</td>
				<td>${tripDetails.car.make}</td>
			</tr>
			<tr>
				<td>Car Model</td>
				<td>${tripDetails.car.model}</td>
			</tr>
			<tr>
				<td>Car Number</td>
				<td>${tripDetails.car.carNumber}</td>
			</tr>
		
		
		
		</table>		
	
	</c:otherwise>


</c:choose>


</div>
</body>
</html>