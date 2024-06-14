package com.cab.service;

import java.util.List;

import com.cab.dto.Car;

public interface ICabService {

	String addCar(Car car);
	Car getCarDetails(String carNumber);
	List<Car> searchCab(String from, String to);
}
