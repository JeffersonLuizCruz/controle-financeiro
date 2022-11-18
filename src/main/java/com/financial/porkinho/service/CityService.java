package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.City;

public interface CityService {

	City save(City city);
	City update(City city);
	List<City> findAll();
	City findById(Long id);
	void delete(Long id);
}
