<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>Drive and Deliver</title>
</head>
<body>
<div align="center">


   <h2>${message}</h2>
<!--    <a href="login">Login</a>
   <a href="accountsummary?emailId=asdhammu@gmail.com">Driver</a>
   
   <a href="accountsummary?emailId=testing@test.com">Sender</a>
 -->

	<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

		<h3><a href="accountsummary?username=${pageContext.request.userPrincipal.name}">Account Summary</a></h3>
    </c:if>

</div>
	
</div>
</body>
</html>