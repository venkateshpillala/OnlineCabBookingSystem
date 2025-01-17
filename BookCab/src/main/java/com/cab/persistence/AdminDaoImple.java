package com.cab.persistence;

import com.cab.dto.Admin;
import com.cab.dto.BookedCabs;
import com.cab.utility.JdbcConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImple implements IAdminDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	
	@Override
	public Admin getAdminDetails(String username) {

		Admin admin = null;		
		query = "SELECT * FROM admin WHERE username = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null) 
				pstmt = con.prepareStatement(query);
			if(pstmt != null)
				pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				admin = new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public List<BookedCabs> allBookings() {

		List<BookedCabs> bookedCabs = null;
		query = "SELECT * FROM bookedcabs";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null)
				rs = pstmt.executeQuery();
			if(rs != null) {
				bookedCabs = new ArrayList<BookedCabs>();
				while(rs.next()) {
					BookedCabs booked = new BookedCabs(); 
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
					
					bookedCabs.add(booked);
				}
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bookedCabs;
	}

	@Override
	public String removeCab(String carNumber) {

		int c = 0;
		query = "DELETE FROM car WHERE carnumber = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, carNumber);
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
}
