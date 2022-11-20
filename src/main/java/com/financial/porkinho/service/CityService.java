package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.City;

public interface CityService {

	City save(City city);
	City update(Long id, City city);
	List<City> findAll();
	City findById(Long id);
	void deleteById(Long id);
	City checkIfCityExists(Long id);
}
