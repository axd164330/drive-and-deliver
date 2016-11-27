<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Address List</title>
</head>
<body>

<a href="${contextPath}/">Back to Home</a>

<div align="center">
	
	
	
	
	<h3>Profile Address List</h3>
	<br/>
	
	<a href="addAddress">Add Address</a>
	<br/>
	<c:choose>
		<c:when test="${addressList == null}">
			Please add address to your profile.
				
		</c:when>
		<c:otherwise>
			<c:forEach var="addressList" items="${addressList}">
				<div>
					Street 1 : ${addressList.address1} <br/>
					Street 2 : ${addressList.address2} <br/>			
					City : ${addressList.city} <br/>
					Phone number  : ${addressList.phoneNo} <br/>
					pin code : ${addressList.poBox} <br/>
				</div>	
			</c:forEach>
			
		
		</c:otherwise>
	
	</c:choose>
</div>
</body>
</html>