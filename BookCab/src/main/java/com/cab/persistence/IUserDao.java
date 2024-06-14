package com.cab.persistence;

import java.util.List;

import com.cab.dto.BookedCabs;
import com.cab.dto.Car;
import com.cab.dto.User;

public interface IUserDao {

	String insertUser(User user);
	User getUserDetails(String username);
	String bookingSuccess(User user,Car car,String time);
	BookedCabs getBookedCabDetails(User user,Car car,String time);
	String cancelBooking(String username, String carNumber, String time);
	List<BookedCabs> myBookings(String username);
}
