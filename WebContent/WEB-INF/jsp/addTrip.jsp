<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a TRIP</title>
</head>
<body>

<a href="/">Back to Home</a>

<div align="center">
        <form:form action="addtripdetails" method="post" commandName="tripForm">
        	<form:hidden path="emailId" value="${emailId}"/>
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>TRIP - Registration</h2></td>
                </tr>
                <tr>
                    <td>Time of Travel(mm/dd/yyyy):</td>
                    <td><form:input path="dateOfTrip" /></td>
                </tr>
                <tr>
                    <td><h3>Starting Address :</h3></td>
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
                    <td><h3>Car Details</h3></td>
                    <td>Car Number</td>
                    <td><form:input path="carNumber" /></td>
                </tr>
                <tr>
                    <td>Car Model</td>
                    <td><form:input path="carModel" /></td>
                </tr>
                <tr>
                    <td>Car Make</td>
                    <td><form:input path="carMake" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add Trip" /></td>
                </tr>
            </table>
        </form:form>
    </div>

</body>
</html>