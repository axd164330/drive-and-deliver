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

<a href="/">Back to Home</a>

<div align="center">

<h2>Trip Details</h2>


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

<h3> Car Details </h3>
Make : ${tripDetails.car.make}
Model : ${tripDetails.car.model}
Car Number : ${tripDetails.car.carNumber}

</div>

</body>
</html>