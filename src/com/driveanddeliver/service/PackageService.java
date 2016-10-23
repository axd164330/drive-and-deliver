package com.driveanddeliver.service;

import com.driveanddeliver.model.User;
import com.driveanddeliver.model.PackageFormData;
import com.driveanddeliver.model.MyPackage;

public interface PackageService {
	public void savePackageDetails(User user,PackageFormData carPackage);
	
	public MyPackage getPackageDetails(int id);
	
}
