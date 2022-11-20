package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.City;
import com.financial.porkinho.domain.model.State;
import com.financial.porkinho.repository.CityRepository;
import com.financial.porkinho.service.CityService;
import com.financial.porkinho.service.StateService;

@Service
public class CityServiceImpl implements CityService{

	private final CityRepository cityRepository;
	private final StateService stateService;
	
	public CityServiceImpl(CityRepository cityRepository, StateService stateService) {
		this.cityRepository = cityRepository;
		this.stateService = stateService;
	}

	@Override
	public City save(City city) {
		State stateEntity = stateService.checkIfStateExists(city.getState().getId());
		city.setState(stateEntity);
		return cityRepository.save(city);
	}

	@Override
	public City update(Long id, City city) {
		checkIfCityExists(id);
		stateService.checkIfStateExists(city.getState().getId());
		
		city.setId(id);
		city.setState(city.getState());

		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City findById(Long id) {
		return checkIfCityExists(id);
	}

	@Override
	public void deleteById(Long id) {
		City cityEntity = checkIfCityExists(id);
		cityRepository.delete(cityEntity);
		
	}

	@Override
	public City checkIfCityExists(Long id) {
		return cityRepository.findById(id).orElseThrow(() ->
		new RuntimeException("TODO - Implement exception handler"));
	}
}
