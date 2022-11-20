package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.Kitchen;
import com.financial.porkinho.repository.KitchenRepository;
import com.financial.porkinho.service.KitchenService;

@Service
public class KitchenServiceImpl implements KitchenService{

	private final KitchenRepository kitchenRepository;
	
	public KitchenServiceImpl(KitchenRepository kitchenRepository) {
		this.kitchenRepository = kitchenRepository;
	}

	@Override
	public Kitchen save(Kitchen kitchen) {
		return kitchenRepository.save(kitchen);
	}

	@Override
	public Kitchen update(Long id, Kitchen kitchen) {
		checkIfObjectExists(id);
		kitchen.setId(id);
		
		return kitchenRepository.save(kitchen);
	}

	@Override
	public List<Kitchen> findAll() {
		return kitchenRepository.findAll();
	}

	@Override
	public Kitchen findById(Long id) {
		return checkIfObjectExists(id);
	}

	@Override
	public void deleteById(Long id) {
		Kitchen kitchenEntity = checkIfObjectExists(id);
		kitchenRepository.delete(kitchenEntity);
	}
	
	private Kitchen checkIfObjectExists(Long id) {
		return kitchenRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO - Implement exception")); 
	}

}
