package com.driveanddeliver.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.driveanddeliver.model.TripFormData;

@Component
public class TripValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return TripFormData.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		
		//TripFormData trip = (TripFormData) arg0;
			
		
		ValidationUtils.rejectIfEmpty(errors, "dateOfTrip", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripStreet1", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripStreet2", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripCity", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripState", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripCountry", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "startTripPin", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripStreet1", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripStreet2", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripCity", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripState", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripCountry", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "endTripPin", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "carNumber", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "carMake", "NotEmpty");
		ValidationUtils.rejectIfEmpty(errors, "carModel", "NotEmpty");				
		
		
	}

}
