package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.Institution;
import com.financial.porkinho.repository.InstitutionRepository;
import com.financial.porkinho.service.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService{

	private  InstitutionRepository institutionRepository;
	
	public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
		this.institutionRepository = institutionRepository;
	}
	
	@Override
	public Institution save(Institution institution) {
		return institutionRepository.save(institution);
	}

	@Override
	public Institution update(Long id, Institution institution) {
		Institution institutionEntity = verifyIfExistsInstitution(id);
		institutionEntity.setId(id);
		
		return institutionRepository.save(institution);
	}

	@Override
	public List<Institution> findAll() {
		return institutionRepository.findAll();
	}

	@Override
	public Institution findById(Long id) {
		return verifyIfExistsInstitution(id);
	}

	private Institution verifyIfExistsInstitution(Long id) {
		return institutionRepository.findById(id)
				.orElseThrow(
				() -> new RuntimeException("message"));
	}
}
