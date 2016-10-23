<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip History</title>
</head>
<body>

Context Path : ${contextPath}

<a href="${contextPath}/">Back to Home</a>
<div align="center">
<h2>Trip History</h2>

<c:forEach var="packages" items="${packages}">

	<h3><a href="${contextPath}/packageDetails?id=${packages.id}">Trip ID : ${packages.id}</a> Trip Date: ${packages.pickupDate}  </h3>

</c:forEach>
</div>
</body>
</html>