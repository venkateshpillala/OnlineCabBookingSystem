package com.cab.persistence;

import java.util.List;

import com.cab.dto.Admin;
import com.cab.dto.BookedCabs;

public interface IAdminDao {
	Admin getAdminDetails(String username);
	List<BookedCabs> allBookings();
	String removeCab(String carNumber);
}
