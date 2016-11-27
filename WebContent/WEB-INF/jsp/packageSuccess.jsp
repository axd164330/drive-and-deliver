<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip Success</title>
</head>

<a href="${contextPath}">Back to Home</a>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Delivery request added successfully</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>We will mail you details of the driver of your package soon! </h3>
                    <!--Here's the review of your details:</h3> -->
                </td>
            </tr>
            <%-- <tr>
                <td>User Name:</td>
                <td>${userForm.username}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${userForm.email}</td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td>${userForm.birthDate}</td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>${userForm.profession}</td>
            </tr>
  --%>
        </table>
    </div>
</body></html>