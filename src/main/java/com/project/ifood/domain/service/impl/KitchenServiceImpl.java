package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Kitchen;
import com.project.ifood.domain.repositoy.KitchenRepository;
import com.project.ifood.domain.service.KitchenService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

@Service
public class KitchenServiceImpl implements KitchenService{

	private final KitchenRepository kitchenRepository;
	
	public KitchenServiceImpl(KitchenRepository kitchenRepository) {
		this.kitchenRepository = kitchenRepository;
	}

	private final String CONSTRAINT_VALIDATION_MESSAGE = "Cozinha de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Cozinha de código '%d' não encontrado.";
	@Transactional
	@Override
	public Kitchen save(Kitchen kitchen) {
		return kitchenRepository.save(kitchen);
	}
	@Transactional
	@Override
	public Kitchen update(Long id, Kitchen kitchen) {
		checkIfKitchenExists(id);
		kitchen.setId(id);
		
		return kitchenRepository.save(kitchen);
	}

	@Override
	public List<Kitchen> findAll() {
		return kitchenRepository.findAll();
	}

	@Override
	public Kitchen findById(Long id) {
		return checkIfKitchenExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {

		try {
			Kitchen kitchenEntity = checkIfKitchenExists(id);
			kitchenRepository.delete(kitchenEntity);
			kitchenRepository.flush();
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}
	
	@Override
	public Kitchen checkIfKitchenExists(Long id) {
		return kitchenRepository.findById(id).orElseThrow(() ->
				new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
