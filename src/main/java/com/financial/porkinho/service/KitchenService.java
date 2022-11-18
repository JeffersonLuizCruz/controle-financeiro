package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.Kitchen;

public interface KitchenService {

	Kitchen save(Kitchen kitchen);
	Kitchen update(Long id, Kitchen kitchen);
	List<Kitchen> findAll();
	Kitchen findById(Long id);
	void delete(Long id);
}
