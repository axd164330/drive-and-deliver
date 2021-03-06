package com.driveanddeliver.service;

import com.driveanddeliver.dao.PackageDAO;
import com.driveanddeliver.model.MyPackage;
import com.driveanddeliver.model.PackageFormData;
import com.driveanddeliver.model.User;

public class PackageServiceImpl implements PackageService {

	private PackageDAO packageDAO;
	
	public PackageDAO getPackageDAO() {
		return this.packageDAO;
	}
	
	public void setPackageDAO(PackageDAO packageDAO) {
		this.packageDAO = packageDAO;
	}
	
	@Override
	public void savePackageDetails(User user,PackageFormData carPackage) {
		
		this.packageDAO.savePackageDetails(user, carPackage);
	}

	@Override
	public MyPackage getPackageDetails(int id) {
		return this.packageDAO.getPackageDetails(id);
	}

	@Override
	public void updatePackageDetails(MyPackage myPackage) {
		this.getPackageDAO().updatePackageDetails(myPackage);
		
	}
}
