package com.cab.service;

import java.util.List;

import com.cab.dto.Admin;
import com.cab.dto.BookedCabs;

public interface IAdminService {

	Admin getAdminDetails(String username);
	List<BookedCabs> allBookings();
	String removeCab(String carNumber);
}
