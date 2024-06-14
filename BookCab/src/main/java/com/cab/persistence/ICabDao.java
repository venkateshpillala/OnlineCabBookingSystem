package com.cab.persistence;

import java.util.List;

import com.cab.dto.Car;

public interface ICabDao {
	String addCar(Car car);
	Car getCarDetails(String carNumber);
	List<Car> searchCab(String from, String to);
}
