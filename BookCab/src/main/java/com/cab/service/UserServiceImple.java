package com.cab.service;

import java.util.List;

import com.cab.dto.BookedCabs;
import com.cab.dto.Car;
import com.cab.dto.User;
import com.cab.persistence.*;

public class UserServiceImple implements IUserService {

	
	
	@Override
	public String insertUser(User user) { 
		return new UserDaoImple().insertUser(user);			
	}

	@Override
	public User getUserDetails(String username) {
		return new UserDaoImple().getUserDetails(username);
	}

	@Override
	public String bookingSuccess(User user, Car car,String time) {
		return new UserDaoImple().bookingSuccess(user, car, time);
	}

	@Override
	public BookedCabs getBookedCabDetails(User user,Car car,String time) {
		return new UserDaoImple().getBookedCabDetails(user,car,time);
	}

	@Override
	public String cancelBooking(String username, String carNumber, String time) {
		return new UserDaoImple().cancelBooking(username, carNumber, time);
	}

	@Override
	public List<BookedCabs> myBookings(String username) {
		return new UserDaoImple().myBookings(username);
	}

}
