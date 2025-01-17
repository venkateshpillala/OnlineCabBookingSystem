package com.cab.service;

import java.util.List;

import com.cab.dto.Admin;
import com.cab.dto.BookedCabs;
import com.cab.persistence.AdminDaoImple;

public class AdminServiceImple implements IAdminService {

	@Override
	public Admin getAdminDetails(String username) {		
		return new AdminDaoImple().getAdminDetails(username);
	}

	@Override
	public List<BookedCabs> allBookings() {
		return new AdminDaoImple().allBookings();
	}

	@Override
	public String removeCab(String carNumber) {		
		return new AdminDaoImple().removeCab(carNumber);
	}

}
