<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Package</title>
<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
    <style>
      #locationField, #controls {
        position: relative;
        width: 480px;
      }
      #autocomplete {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 99%;
      }
      #autocomplete2 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 99%;
      }
      .label {
        text-align: right;
        font-weight: bold;
        width: 100px;
        color: #303030;
      }
      #address {
        border: 1px solid #000090;
        background-color: #f0f0ff;
        width: 480px;
        padding-right: 2px;
      }
      #address td {
        font-size: 10pt;
      }
      .field {
        width: 99%;
      }
      .slimField {
        width: 80px;
      }
      .wideField {
        width: 200px;
      }
      #locationField {
        height: 20px;
        margin-bottom: 2px;
      }
    </style>
</head>
<body>

<a href="${contextPath}">Back to Home</a>

<div align="center">
		
		
		<h2 align="center">Package Details</h2>
		
        <form:form action="addpackagedetails" method="post" commandName="packageForm">
        	
           		<h3>Starting Address :</h3>
        		
        		<form:hidden path="emailId" value="${emailId}"/>
	        	<div id="locationField">
	      			<input id="autocomplete" placeholder="Enter your address"
	             			onFocus="geolocate()" type="text"></input>
	    		</div>
        	
            	<table id="address" border="0">
                
                <tr>
                    <td>Street 1</td>
                    <td><form:input id="street_number" path="startTripStreet1" /></td>
                </tr>
                <tr>
                    <td>Street2:</td>
                    <td><form:input id="route"  path="startTripStreet2" /></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><form:input id="locality" path="startTripCity" /></td>
                </tr>
                <tr>
                	<td>State</td>
                	<td><form:input id="administrative_area_level_1" path="startTripState" /></td>
                </tr>
                <tr>
                	<td>Country</td>
                	<td><form:input id="country" path="startTripCountry" /></td>
                </tr>
                <tr>
                    <td>PIN</td>
                    <td><form:input id="postal_code" path="startTripPin" /></td>
                </tr>
              
                <%-- <tr>
                    <td>Phone</td>
                    <td><form:input path="startTripPhone" /></td>
                </tr> --%>
                <tr>
                    <td>Time of Travel(mm/dd/yyyy):</td>
                    <td><form:input path="dateOfTrip" id="prefMovingDate" /></td>
                </tr>
                
                </table>
                <h3>Destination Address :</h3>
              	
              	<div id="locationField">
      			<input id="autocomplete2" placeholder="Enter your address"
             			onFocus="geolocate()" type="text"></input>
    			</div>
              
              	<table id="address">
	                <tr>
	                    <td>Street 1</td>
	                    <td><form:input path="endTripStreet1" id="estreet_number" /></td>
	                </tr>
	                <tr>
	                    <td>Street2:</td>
	                    <td><form:input path="endTripStreet2" id="eroute" /></td>
	                </tr>
	                <tr>
	                    <td>City</td>
	                    <td><form:input path="endTripCity" id="elocality" /></td>
	                </tr>   
	                 <tr>
	                	<td>State</td>
	                	<td><form:input id="eadministrative_area_level_1" path="endTripState" /></td>
	                </tr>
	                <tr>
	                	<td>Country</td>
	                	<td><form:input id="ecountry" path="endTripCountry" /></td>
	                </tr>             
	                <tr>
	                    <td>PIN</td>
	                    <td><form:input id="epostal_code" path="endTripPin" /></td>
	                </tr>
	                <%-- <tr>
	                    <td>Phone</td>
	                    <td><form:input path="endTripPhone" /></td>
	                </tr> --%>
                </table>
                <h3>Package Details</h3>
                <table id="address">
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
	                             
            	</table>
            	<table>
            		<tr>
            			<td colspan="2" align="center"><input type="submit" value="Add Package" /></td>
            		</tr>
            	</table>
        </form:form>
    </div>
<script>
      // This example displays an address form, using the autocomplete feature
      // of the Google Places API to help users fill in the information.

      // This example requires the Places library. Include the libraries=places
      // parameter when you first load the API. For example:
      // <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">

      var placeSearch, autocomplete;
      var componentForm = {
        street_number: 'short_name',
        route: 'long_name',
        locality: 'long_name',
        administrative_area_level_1: 'short_name',
        country: 'long_name',
        postal_code: 'short_name'
      };
      
      var componentForm2 = ["estreet_number","eroute","elocality","eadministrative_area_level_1","ecountry","epostal_code"];
      
      var map = {"street_number":"estreet_number",
    		  "route":"eroute",
    		  "locality":"elocality",
    		  "administrative_area_level_1":"eadministrative_area_level_1",
    		  "country":"ecountry",
    		  "postal_code":"epostal_code"
      };
      

      function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.
        autocomplete = new google.maps.places.Autocomplete(
            /** @type {!HTMLInputElement} */(document.getElementById('autocomplete')),
            {types: ['geocode']});
        autocomplete2 = new google.maps.places.Autocomplete(
                /** @type {!HTMLInputElement} */(document.getElementById('autocomplete2')),
                {types: ['geocode']});

        // When the user selects an address from the dropdown, populate the address
        // fields in the form.
        autocomplete.addListener('place_changed', fillInAddress);
        autocomplete2.addListener('place_changed', fillInAddress2);
      }

      function fillInAddress() {
        // Get the place details from the autocomplete object.
        var place = autocomplete.getPlace();

        for (var component in componentForm) {
          document.getElementById(component).value = '';
          document.getElementById(component).disabled = false;
        }

        // Get each component of the address from the place details
        // and fill the corresponding field on the form.
        for (var i = 0; i < place.address_components.length; i++) {
          var addressType = place.address_components[i].types[0];
          if (componentForm[addressType]) {
            var val = place.address_components[i][componentForm[addressType]];
            document.getElementById(addressType).value = val;
          }
        }
      }
      
      function fillInAddress2() {
          // Get the place details from the autocomplete object.
          var place = autocomplete2.getPlace();

          for (var i=0;i<componentForm2.length;i++) {
            document.getElementById(componentForm2[i]).value = '';
            document.getElementById(componentForm2[i]).disabled = false;
          }

          // Get each component of the address from the place details
          // and fill the corresponding field on the form.
          for (var i = 0; i < place.address_components.length; i++) {
            var addressType = place.address_components[i].types[0];
            if (componentForm[addressType]) {
              var val = place.address_components[i][componentForm[addressType]];
              document.getElementById(map[addressType]).value = val;
            }
          }
        }


      // Bias the autocomplete object to the user's geographical location,
      // as supplied by the browser's 'navigator.geolocation' object.
      function geolocate() {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var geolocation = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            var circle = new google.maps.Circle({
              center: geolocation,
              radius: position.coords.accuracy
            });
            autocomplete.setBounds(circle.getBounds());
          });
        }
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAWC6jrdKhG_yXU5o9pAVy6PRD5djgI7fY&libraries=places&callback=initAutocomplete"
        async defer></script>


</body>
</html>