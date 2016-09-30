<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Summary</title>
</head>

<a href="${contextPath}/">Back to Home</a>
<body>
<div align="center">
<h1>Account Summary Page</h1>
<br/>

<a href="${contextPath}/addtrip?emailId=${driver.emailId}">Add Trip</a>

<a href="${contextPath}/triphistory?emailId=${driver.emailId}">Trip History</a>
<br/>
 First Name: ${driver.name}
<br/>
Country: ${driver.country}
<br/>
Addresses:  <br/>
<br/>
<c:forEach var="addressList" items="${driver.addresses}">
	Street 1 : ${addressList.address1} <br/>
	Street 2 : ${addressList.address2} <br/>
	
	City : ${addressList.city} <br/>
	Phone number  : ${addressList.phoneNo} <br/>
	pin code : ${addressList.poBox} <br/>
	<br/>
</c:forEach>
 

</div>

</body>
</html>