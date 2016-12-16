<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

//Get the modal
var modal = document.getElementById('cancelPackageModal');

// Get the button that opens the modal
var btn = document.getElementById("cancelPackage");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

$("#cancelPackage button").click(function(){
	
}
		
		);


</script>
<style type="text/css">

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Package History</title>
</head>
<body>



<a href="${contextPath}/">Back to Home</a>
<div align="center">
<h2>Package History</h2>

<div align="center">
		<h2>Package History</h2>
			
			<table border="1">
				<tr>
					<th>Package Details</th>
					<th>Time Of Trip</th>
					<!-- <th>Edit Trip</th>
					<th>Delete Trip</th> -->
					<th>Trip Status</th>
				</tr>
			
				<c:forEach var="packages" items="${packages}">
				<tr>
					
					<td><a href="packageDetails?id=${packages.id}">View Details</a></td>
					<td>${packages.pickupDate}</td>
					<%-- <td><a href="edittrip?id=${trip.id}&e=true">Edit</a></td>
					<td><a href="deleteTrip?id=${trip.id}">Delete</a></td> --%>
					<td>${packages.packageStatus}</td>					
				</tr>
				</c:forEach>
			</table>
			
			
		
	</div>



<%-- <div id="myId">
<c:forEach var="packages" items="${packages}">
	
	<ul><a href="packageDetails?id=${packages.id}">Trip ID : ${packages.id}</a> Trip Date: ${packages.pickupDate} <button id="${packages.id}" class="cancelPackage">Cancel</button>
	</ul>
</c:forEach>

</div>
<div id="cancelPackageModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">×</span>
    <p>Do you want to cancel the package?</p>
    
    <form action="/cancelPackage">
    	
    	<input type="submit" value="YES"/>
    </form>
    
  </div>


</div> --%>
</div>

</body>
</html>