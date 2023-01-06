package com.project.ifood.domain.service;

public interface GroupRoleService {

	void disassociateRole(Long groupId, Long roleId);
	void associateRole(Long groupId, Long roleId);
}
