package com.driveanddeliver.service;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.MyPackage;
import com.driveanddeliver.model.Trip;
import com.driveanddeliver.model.User;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;

@Controller
public class DistanceService {

	
	@Autowired
	UserService userService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DistanceService.class);
	
	@RequestMapping(value="/match", method=RequestMethod.GET)
	public String match(ModelMap map){
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in user name
	    
	    User user = userService.getUserDetails(username);
		
	    
	    
	    List<MyPackage> packages = user.getPackages();
	    
	    
	    packages.sort(new Comparator<MyPackage>() {

			@Override
			public int compare(MyPackage arg0, MyPackage arg1) {
				// TODO Auto-generated method stub
				return arg1.getTimestamp().compareTo(arg0.getTimestamp());
			}
		});
	    
	    MyPackage myPackage = packages.get(0);
	    
	    Address packageOrigAddress = myPackage.getAddress().get(0);
	    Address packageDestAddress = myPackage.getAddress().get(1);
	    
		List<Trip> tripList = userService.getTripsForNextWeek();
				
		GeoApiContext apiContext = new GeoApiContext();
		
		apiContext.setApiKey("AIzaSyAWC6jrdKhG_yXU5o9pAVy6PRD5djgI7fY");
	
			
		GeocodingResult[] packageOriginResult;
		GeocodingResult[] packageDestResult;	
		
		
		GeocodingResult[] tripOriginResult;
		GeocodingResult[] tripDestResult;	
		boolean matchFound = false;
		
		try {	
			
			for(Trip trip:tripList){
				
				if(trip.getTimeOfTravel().after(myPackage.getPickupDate())){
					continue;
				}
				
				Address tripOriginAddress = trip.getAddress().get(0);
				
				Address tripDestAddress = trip.getAddress().get(1);
			
				packageOriginResult = GeocodingApi.geocode(apiContext, packageOrigAddress.getAddress1() + packageOrigAddress.getAddress2()).await();
				
				packageDestResult = GeocodingApi.geocode(apiContext, packageDestAddress.getAddress1() + packageDestAddress.getAddress2()).await();
				
				
				tripOriginResult = GeocodingApi.geocode(apiContext, tripOriginAddress.getAddress1() + tripOriginAddress.getAddress2()).await();
				
				tripDestResult = GeocodingApi.geocode(apiContext, tripDestAddress.getAddress1() + tripDestAddress.getAddress2()).await();
				
				
				LatLng packageOrig = new LatLng(packageOriginResult[0].geometry.location.lat, packageOriginResult[0].geometry.location.lng);
				LatLng packagedest = new LatLng(packageDestResult[0].geometry.location.lat, packageDestResult[0].geometry.location.lng);

				LatLng tripOrigin = new LatLng(tripOriginResult[0].geometry.location.lat, tripOriginResult[0].geometry.location.lng);
				LatLng tripDest = new LatLng(tripDestResult[0].geometry.location.lat, tripDestResult[0].geometry.location.lng);
					
				
				DirectionsResult directionsResult = DirectionsApi.newRequest(apiContext).mode(TravelMode.DRIVING).origin(tripOrigin).destination(tripDest).await();
				
				System.out.println("Route" + directionsResult.routes[0].legs[0].steps);
				
				
				/**
				 * check the pickup location of package lies on the drivers route or not
				 */
				int i=0;
				
				double distanceFromStartPoint=0,distanceFromEndPoint;
				for(DirectionsStep directionsStep:directionsResult.routes[0].legs[0].steps){
					
					distanceFromStartPoint = distance(packageOrig.lat, packageOrig.lng, directionsStep.startLocation.lat, directionsStep.startLocation.lng, "M");
					distanceFromEndPoint = distance(packageOrig.lat, packageOrig.lng, directionsStep.endLocation.lat, directionsStep.endLocation.lng, "M");
					i++;
					if(distanceFromStartPoint <= 50 || distanceFromEndPoint <=50){
						
						matchFound = isMatchFound(packagedest, directionsResult, i, matchFound);
						
					}
					
					if(matchFound){
						break;
					}
					
				}
				
				if(matchFound){
					map.put("message", "matchFound");
					map.put("driver", trip.getUser());
					map.put("tripDetails", trip);
					break;
					
				}
				
			}
			
			if(!matchFound){
				
				map.put("message", "We ll get back to you shortly with details");
				
			}
		} catch (Exception e) {
			logger.error("Exception while calling google API" + e);
		}
		
		
		return "matchDetails";
	}



	/**
	 * THis  method returns if the match is found or not
	 * 
	 * @param packagedest
	 * @param directionsResult
	 * @param i
	 * @param matchFound
	 * @return
	 */
	private boolean isMatchFound(LatLng packagedest, DirectionsResult directionsResult, int i, boolean matchFound) {
		int len = directionsResult.routes[0].legs[0].steps.length;
		
		
		for(int j=i;j<len;j++){							
			DirectionsStep remainingSteps = directionsResult.routes[0].legs[0].steps[j];							
			
			double distanceToPackDest = distance(packagedest.lat, packagedest.lng, remainingSteps.startLocation.lat, remainingSteps.startLocation.lng, "M");
			double distanceToPackDest2 = distance(packagedest.lat, packagedest.lng, remainingSteps.endLocation.lat, remainingSteps.endLocation.lng, "M");
			
			if(distanceToPackDest <= 50 || distanceToPackDest2 <=50){								
				matchFound = true;							
				break;
			}
		}
		return matchFound;
	}
	
	
	
	/**
	 * Returns the distance between tow points with latitude and longitude
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @return
	 */
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == "K") {
			dist = dist * 1.609344;
		} else if (unit == "N") {
			dist = dist * 0.8684;
		}

		return (dist);
	}
	
	/**
	 * Converts decimal degrees to radians
	 * @param deg
	 * @return
	 */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * Converts radians to decimal degress
	 * @param rad
	 * @return
	 */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	
}


