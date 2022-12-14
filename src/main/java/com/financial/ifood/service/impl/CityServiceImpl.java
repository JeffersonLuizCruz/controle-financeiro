package com.financial.ifood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.ifood.domain.model.City;
import com.financial.ifood.domain.model.State;
import com.financial.ifood.repository.CityRepository;
import com.financial.ifood.service.CityService;
import com.financial.ifood.service.StateService;
import com.financial.ifood.service.exception.CityNotFoundException;

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
		new CityNotFoundException("Cidade não encontrada id " + id));
	}
}
