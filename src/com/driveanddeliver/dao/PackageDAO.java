package com.driveanddeliver.dao;

import com.driveanddeliver.model.MyPackage;
import com.driveanddeliver.model.PackageFormData;
import com.driveanddeliver.model.User;

public interface PackageDAO {
	
	public void savePackageDetails(User user, PackageFormData data);
	
	public MyPackage getPackageDetails(int id);

	public void updatePackageDetails(MyPackage myPackage);
}

