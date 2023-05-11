package com.bikeRentalSystem.service;

import java.util.List;

import com.bikeRentalSystem.beans.Bike;

public interface BikeDetailsService {

	int save(Bike b);

	int update(Bike b);

	int delete(int bikeId);

	Bike getBikeById(int bikeId);

	Bike getBikeByName(String bikeName);

	List<Bike> getBikes();

}