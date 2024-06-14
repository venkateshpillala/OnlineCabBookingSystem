package com.cab.service;

import java.util.List;

import com.cab.dto.Car;
import com.cab.persistence.CabDaoImple;

public class CabServiceImple implements ICabService {

	@Override
	public String addCar(Car car) {
		return new CabDaoImple().addCar(car);
	}

	@Override
	public Car getCarDetails(String carNumber) {
		return new CabDaoImple().getCarDetails(carNumber);
	}

	@Override
	public List<Car> searchCab(String from, String to) {
		return new CabDaoImple().searchCab(from, to);
	}

}
