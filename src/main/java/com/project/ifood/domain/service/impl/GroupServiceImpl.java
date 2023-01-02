package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.ProfileGroup;
import com.project.ifood.domain.repositoy.GroupRepository;
import com.project.ifood.domain.service.GroupService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

	private final GroupRepository groupRepository;
	
	private final String CONSTRAINT_VALIDATION_MESSAGE = "Grupo de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Grupo de código '%d' não encontrado.";
	
	@Override
	public ProfileGroup save(ProfileGroup group) {
		return groupRepository.save(group);
	}

	@Override
	public ProfileGroup update(Long id, ProfileGroup group) {
		checkIfGroupExists(id);
		group.setId(id);
		
		return groupRepository.save(group);
	}

	@Override
	public List<ProfileGroup> findAll() {
		return groupRepository.findAll();
	}

	@Override
	public ProfileGroup findById(Long id) {
		return checkIfGroupExists(id);
	}

	@Override
	public void deleteById(Long id) {
		try {
			ProfileGroup groupEntity = checkIfGroupExists(id);
			groupRepository.delete(groupEntity);
			groupRepository.flush();
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}
	

	@Override
	public ProfileGroup checkIfGroupExists(Long id) {
		return groupRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
