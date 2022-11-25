package com.financial.ifood.service;

import java.util.List;

import com.financial.ifood.domain.model.City;

public interface CityService {

	City save(City city);
	City update(Long id, City city);
	List<City> findAll();
	City findById(Long id);
	void deleteById(Long id);
	City checkIfCityExists(Long id);
}
