<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<c:forEach var="trip" items="${trips}">

			<h3>
				<a href="${contextPath}/tripDetails?id=${trip.id}&e=false">Trip ID :
					${trip.id}</a> Trip Date: ${trip.timeOfTravel} <a
					href="${contextPath}/edittrip?id=${trip.id}&e=true">Edit</a> <a
					href="${contextPath}/deleteTrip?id=${trip.id}">Delete</a>
			</h3>

		</c:forEach>
	</div>
</body>
</html>