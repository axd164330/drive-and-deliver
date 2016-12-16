<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip History</title>
</head>
<body>

	<a href="${contextPath}/">Back to Home</a>
	<div align="center">
		<h2>Trip History</h2>

		

			
			<table border="1">
				<tr>
					<th>Trip Details</th>
					<th>Time Of Trip</th>
					<th>Edit Trip</th>
					<th>Delete Trip</th>
					<th>Trip Status</th>
				</tr>
			
				<c:forEach var="trip" items="${trips}">
				<tr>
					
					<td><a href="tripDetails?id=${trip.id}&e=false">View Details</a></td>
					<td>${trip.timeOfTravel}</td>
					<td><a href="edittrip?id=${trip.id}&e=true">Edit</a></td>
					<td><a href="deleteTrip?id=${trip.id}">Delete</a></td>
					<td>${trip.tripStatus}</td>					
				</tr>
				</c:forEach>
			</table>
			
			
		
	</div>
</body>
</html>