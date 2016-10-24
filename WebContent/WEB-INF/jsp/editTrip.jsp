<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Trip Details</title>
</head>
<body>

	<a href="${contextPath}/">Back to Home</a>

	<div align="center">
		<form:form action="edittripdetails" method="post"
			commandName="loadedTripForm">
			<form:hidden path="id" value="${tripID}"/>
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Edit Trip Details</h2></td>
				</tr>
				<tr>
					<td>Time of Travel(mm/dd/yyyy):</td>
					<td><form:input path="dateOfTrip"
							value="${loadedTripForm.dateOfTripS}" /></td>
				</tr>
				<tr>
					<td><h3>Starting Address :</h3></td>
					<td>Street 1</td>
					<td><form:input path="startTripStreet1" value="${loadedTripForm.startTripStreet1}" /></td>
				</tr>
				<tr>
					<td>Street2:</td>
					<td><form:input path="startTripStreet2" value="${loadedTripForm.startTripStreet2}"/></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input path="startTripCity" value="${loadedTripForm.startTripCity}" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="startTripPhone" value="${loadedTripForm.startTripPhone}" /></td>
				</tr>
				<tr>
					<td>PIN</td>
					<td><form:input path="startTripPin" value="${loadedTripForm.startTripPin}" /></td>
				</tr>
				<tr>
					<td><h3>Destination Address :</h3></td>
					<td>Street 1</td>
					<td><form:input path="endTripStreet1" value="${loadedTripForm.endTripStreet1}" /></td>
				</tr>
				<tr>
					<td>Street2:</td>
					<td><form:input path="endTripStreet2" value="${loadedTripForm.endTripStreet2}" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input path="endTripCity" value="${loadedTripForm.endTripCity}" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><form:input path="endTripPhone" value="${loadedTripForm.endTripPhone}"/></td>
				</tr>
				<tr>
					<td>PIN</td>
					<td><form:input path="endTripPin" value="${loadedTripForm.endTripPin}" /></td>
				</tr>
				<tr>
					<td><h3>Car Details</h3></td>
					<td>Car Number</td>
					<td><form:input path="carNumber" value="${loadedTripForm.carNumber}" /></td>
				</tr>
				<tr>
					<td>Car Model</td>
					<td><form:input path="carModel" value="${loadedTripForm.carModel}" /></td>
				</tr>
				<tr>
					<td>Car Make</td>
					<td><form:input path="carMake" value="${loadedTripForm.carMake}" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Edit Trip" /></td>
				</tr>
			</table>

		</form:form>
	</div>

</body>
</html>