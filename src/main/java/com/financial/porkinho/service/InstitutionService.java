package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.Institution;

public interface InstitutionService {
	
	Institution save(Institution institution);
	Institution update(Long id, Institution institution);
	List<Institution> findAll();
	Institution findById(Long id);
}
