package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Role;
import com.project.ifood.domain.repositoy.RoleRepository;
import com.project.ifood.domain.service.RoleService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
	
	private final RoleRepository roleRepository;
	
    private final String CONSTRAINT_VALIDATION_MESSAGE = "Permissão de código '%d' não pode ser removida, pois está em uso";
    private final String NOT_FOUND_MESSAGE = "Permissão de código '%d' não encontrado.";
	
    @Transactional
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

    @Transactional
	@Override
	public Role update(Long id, Role role) {
		checkIfRoleExists(id);
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
		return checkIfRoleExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		try {
			Role roleEntity = checkIfRoleExists(id);
			roleRepository.delete(roleEntity);
			roleRepository.flush();
		}catch (DataIntegrityViolationException | ConstraintViolationException e){
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
		
	}

	@Override
	public Role checkIfRoleExists(Long id) {
		return roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}
