package com.financial.ifood.service.impl;

import java.util.List;

import com.financial.ifood.service.exception.ConstraintViolationService;
import com.financial.ifood.service.exception.NotFoundExceptionService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.financial.ifood.domain.model.Kitchen;
import com.financial.ifood.repository.KitchenRepository;
import com.financial.ifood.service.KitchenService;

@Service
public class KitchenServiceImpl implements KitchenService{

	private final KitchenRepository kitchenRepository;
	
	public KitchenServiceImpl(KitchenRepository kitchenRepository) {
		this.kitchenRepository = kitchenRepository;
	}

	private final String CONSTRAINT_VALIDATION_MESSAGE = "Cozinha de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Cozinha de código '%d' não encontrado.";

	@Override
	public Kitchen save(Kitchen kitchen) {
		return kitchenRepository.save(kitchen);
	}

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

	@Override
	public void deleteById(Long id) {

		try {
			Kitchen kitchenEntity = checkIfKitchenExists(id);
			kitchenRepository.delete(kitchenEntity);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}
	
	@Override
	public Kitchen checkIfKitchenExists(Long id) {
		return kitchenRepository.findById(id).orElseThrow(() ->
				new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
