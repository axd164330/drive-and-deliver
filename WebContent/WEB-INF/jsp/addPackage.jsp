<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a TRIP</title>
</head>
<body>

<a href="${contextPath}">Back to Home</a>

<div align="center">
        <form:form action="addpackagedetails" method="post" commandName="packageForm">
        	<form:hidden path="emailId" value="${emailId}"/>
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>ADD PACKAGE FOR DELIVERY</h2></td>
                </tr>
                <tr>
                    <td>Time of Travel(mm/dd/yyyy):</td>
                    <td><form:input path="dateOfTrip" /></td>
                </tr>
                <tr>
                    <td><h3>Starting Address :</h3></td>
                </tr>
                <tr>
                    <td>Street 1</td>
                    <td><form:input path="startTripStreet1" /></td>
                </tr>
                <tr>
                    <td>Street2:</td>
                    <td><form:input path="startTripStreet2" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><form:input path="startTripCity" /></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><form:input path="startTripPhone" /></td>
                </tr>
                <tr>
                    <td>PIN</td>
                    <td><form:input path="startTripPin" /></td>
                </tr>
                <tr>
                    <td><h3>Destination Address :</h3></td>
                </tr>
                <tr>
                    <td>Street 1</td>
                    <td><form:input path="endTripStreet1" /></td>
                </tr>
                <tr>
                    <td>Street2:</td>
                    <td><form:input path="endTripStreet2" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><form:input path="endTripCity" /></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><form:input path="endTripPhone" /></td>
                </tr>
                <tr>
                    <td>PIN</td>
                    <td><form:input path="endTripPin" /></td>
                </tr>
                <tr>
                    <td><h3>Package Details</h3></td>
                <tr>
                    <td>Length of Package</td>
                    <td><form:input path="length" /></td>
                </tr>
                <tr>
                    <td>Width of Package</td>
                    <td><form:input path="width" /></td>
                </tr>
                <tr>
                    <td>Height of Package</td>
                    <td><form:input path="height" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add Package" /></td>
                </tr>
            </table>
        </form:form>
    </div>

</body>
</html>