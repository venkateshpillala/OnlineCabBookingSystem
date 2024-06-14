package com.cab.persistence;

import com.cab.dto.BookedCabs;
import com.cab.dto.Car;
import com.cab.dto.User;
import com.cab.utility.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImple implements IUserDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	
	@Override
	public String insertUser(User user) {

		int c = 0;
		query = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getEmail());				
				pstmt.setDate(4, new java.sql.Date( new SimpleDateFormat("yyyy-MM-dd").parse(user.getDOB()).getTime()));
				pstmt.setString(5, user.getGender());
				pstmt.setString(6, user.getAddress() );
				pstmt.setString(7, user.getUserNumber());
				c = pstmt.executeUpdate();
			}
				
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(c == 0)
			return "fail";
		else
			return "success";
	}

	@Override
	public User getUserDetails(String username) {

		User user = null;
		query = "SELECT * FROM user WHERE username = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
			}
				user = new User();
				if(rs.next()) {
					user.setUserName(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setDOB(new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(4)));
					user.setGender(rs.getString(5));
					user.setAddress(rs.getString(6));
					user.setUserNumber(rs.getString(7));
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public String bookingSuccess(User user, Car car,String time) {

		query = "INSERT INTO bookedcabs values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int c = 0;
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getEmail());
				pstmt.setDate(3,new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy")
						.parse(user.getDOB()).getTime()));
				pstmt.setString(4,user.getGender());
				pstmt.setString(5, user.getAddress());
				pstmt.setString(6, user.getUserNumber());
				
				pstmt.setString(7, car.getCarNumber());
				pstmt.setString(8, car.getDriverName());
				pstmt.setString(9, car.getCarColour());
				pstmt.setString(10, car.getFromAddress());
				pstmt.setString(11, car.getToAddress());
				pstmt.setString(12, car.getCarType());
				pstmt.setString(13, car.getDriverNumber());
				
				pstmt.setDate(14,new java.sql.Date(new java.util.Date().getTime()));
				pstmt.setString(15, time);
				pstmt.setString(16, "no");
				c = pstmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(c == 0)
			return "fail";
		else
			return "success";
	}

	@Override
	public BookedCabs getBookedCabDetails(User user,Car car,String time) {

		query = "SELECT * FROM bookedcabs WHERE username = ? and carnumber = ? and bookingtime = ?";
		BookedCabs booked = null;
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, car.getCarNumber());
				pstmt.setString(3, time);
				rs = pstmt.executeQuery();
			}
			if(rs != null) {
				booked = new BookedCabs();
				if(rs.next()) {
					booked.setUserName(rs.getString(1));
					booked.setEmail(rs.getString(2));
					booked.setDOB(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(3)));
					booked.setGender(rs.getString(4));
					booked.setAddress(rs.getString(5));
					booked.setUserNumber(rs.getString(6));
					booked.setCarNumber(rs.getString(7));
					booked.setDriverName(rs.getString(8));
					booked.setCarColour(rs.getString(9));
					booked.setFromAddress(rs.getString(10));
					booked.setToAddress(rs.getString(11));
					booked.setCarType(rs.getString(12));
					booked.setDriverNumber(rs.getString(13));
					booked.setDate(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(14)));
					booked.setTime(rs.getString(15));
					booked.setCancel(rs.getString(16));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return booked;
	}

	@Override
	public String cancelBooking(String username, String carNumber, String time) {

		query = "UPDATE bookedcabs set cancel = ? where username = ? and carnumber = ? and bookingtime = ?";
		int c = 0;
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, "canceled");
				pstmt.setString(2, username);
				pstmt.setString(3, carNumber);
				pstmt.setString(4, time);
				c = pstmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(c == 0)
			return "fail";
		else
			return "success";
	}

	@Override
	public List<BookedCabs> myBookings(String username) {

		List<BookedCabs> bookings = null;
		
		query = "SELECT * FROM bookedcabs where username = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) 
				pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs != null) {
				bookings = new ArrayList<BookedCabs>();
				while(rs.next()) {
					BookedCabs booked = new BookedCabs();
					if(booked != null) {
					booked.setUserName(rs.getString(1));
					booked.setEmail(rs.getString(2));
					booked.setDOB(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(3)));
					booked.setGender(rs.getString(4));
					booked.setAddress(rs.getString(5));
					booked.setUserNumber(rs.getString(6));
					booked.setCarNumber(rs.getString(7));
					booked.setDriverName(rs.getString(8));
					booked.setCarColour(rs.getString(9));
					booked.setFromAddress(rs.getString(10));
					booked.setToAddress(rs.getString(11));
					booked.setCarType(rs.getString(12));
					booked.setDriverNumber(rs.getString(13));
					booked.setDate(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(14)));
					booked.setTime(rs.getString(15));
					booked.setCancel(rs.getString(16));
					
					bookings.add(booked);
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return bookings;
	}

	

}
