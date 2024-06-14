package com.cab.persistence;

import com.cab.dto.Car;
import com.cab.utility.JdbcConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CabDaoImple implements ICabDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	
	@Override
	public String addCar(Car car) {

		int c = 0;
		query = "INSERT INTO car VALUES(?,?,?,?,?,?,?)";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, car.getCarNumber());
				pstmt.setString(2, car.getDriverName());
				pstmt.setString(3, car.getCarColour());
				pstmt.setString(4, car.getFromAddress());
				pstmt.setString(5, car.getToAddress());
				pstmt.setString(6, car.getCarType());
				pstmt.setString(7, car.getDriverNumber());
			}
			c = pstmt.executeUpdate();	
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
	public Car getCarDetails(String carNumber) {

		Car car = null;
		query = "SELECT * FROM car WHERE carnumber = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null)
				pstmt.setString(1, carNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				car = new Car();
				car.setCarNumber(rs.getString(1));
				car.setDriverName(rs.getString(2));
				car.setCarColour(rs.getString(3));
				car.setFromAddress(rs.getString(4));
				car.setToAddress(rs.getString(5));
				car.setCarType(rs.getString(6));
				car.setDriverNumber(rs.getString(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return car;
	}

	@Override
	public List<Car> searchCab(String from, String to) {

		List<Car> search = null;
		Car car = null;
		query = "SELECT * FROM car WHERE fromaddress = ? and toaddress = ?";
		try {
			con = JdbcConnection.getJdbcConnection();
			if(con != null)
				pstmt = con.prepareStatement(query);
			if(pstmt != null) {
				pstmt.setString(1, from);
				pstmt.setString(2, to);
				rs = pstmt.executeQuery();
			}
			if(rs != null) {
				search = new ArrayList<Car>();
				while(rs.next()) {
					car = new Car();
					car.setCarNumber(rs.getString(1));
					car.setDriverName(rs.getString(2));
					car.setCarColour(rs.getString(3));
					car.setFromAddress(rs.getString(4));
					car.setToAddress(rs.getString(5));
					car.setCarType(rs.getString(6));
					car.setDriverNumber(rs.getString(7));
					
					search.add(car);
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return search;
	}

}
