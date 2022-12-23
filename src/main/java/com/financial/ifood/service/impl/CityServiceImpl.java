package com.financial.ifood.service.impl;

import java.util.List;

import com.financial.ifood.service.exception.ConstraintViolationService;
import com.financial.ifood.service.exception.NotFoundExceptionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.financial.ifood.domain.model.City;
import com.financial.ifood.domain.model.State;
import com.financial.ifood.repository.CityRepository;
import com.financial.ifood.service.CityService;
import com.financial.ifood.service.StateService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceImpl implements CityService{

	private final CityRepository cityRepository;
	private final StateService stateService;
	
	public CityServiceImpl(CityRepository cityRepository, StateService stateService) {
		this.cityRepository = cityRepository;
		this.stateService = stateService;
	}

	private final String CONSTRAINT_VALIDATION_MESSAGE = "Cidade de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Cidade de código '%d' não encontrado.";

	@Transactional
	@Override
	public City save(City city) {
		State stateEntity = stateService.checkIfStateExists(city.getState().getId());
		city.setState(stateEntity);
		return cityRepository.save(city);
	}
	@Transactional
	@Override
	public City update(Long id, City city) {
		checkIfCityExists(id);
		State stateEntity = stateService.checkIfStateExists(city.getState().getId());
		city.setId(id);
		city.setState(stateEntity);

		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Transactional
	@Override
	public City findById(Long id) {
		return checkIfCityExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {

		try {
			City cityEntity = checkIfCityExists(id);
			cityRepository.delete(cityEntity);
		}catch (DataIntegrityViolationException e){
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));

		}
	}

	@Override
	public City checkIfCityExists(Long id) {
		return cityRepository.findById(id).orElseThrow(() ->
				new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}
}
