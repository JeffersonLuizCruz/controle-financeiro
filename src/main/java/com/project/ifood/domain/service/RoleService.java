package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Role;

public interface RoleService {

	Role save(Role role);
	Role update(Long id, Role role);
	List<Role> findAll();
	Role findById(Long id);
	void deleteById(Long id);
	Role checkIfRoleExists(Long id);
}
