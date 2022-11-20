package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.City;
import com.financial.porkinho.repository.CityRepository;
import com.financial.porkinho.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	private final CityRepository cityRepository;
		
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City update(Long id, City city) {
		checkIfObjectExists(id);
		city.setId(id);
		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City findById(Long id) {
		return checkIfObjectExists(id);
	}

	@Override
	public void delete(Long id) {
		City cityEntity = checkIfObjectExists(id);
		cityRepository.delete(cityEntity);
		
	}

	private City checkIfObjectExists(Long id) {
		return cityRepository.findById(id).orElseThrow(() ->
		new RuntimeException("TODO - Implement exception handler"));
	}
}
