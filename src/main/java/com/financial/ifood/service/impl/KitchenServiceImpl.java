package com.financial.ifood.service.impl;

import java.util.List;

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
		Kitchen kitchenEntity = checkIfKitchenExists(id);
		kitchenRepository.delete(kitchenEntity);
	}
	
	@Override
	public Kitchen checkIfKitchenExists(Long id) {
		return kitchenRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO - Implement exception")); 
	}

}
