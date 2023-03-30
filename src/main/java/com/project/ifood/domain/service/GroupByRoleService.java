package com.project.ifood.domain.service;

public interface GroupByRoleService {

	void disassociate(Long groupId, Long roleId);
	void associate(Long groupId, Long roleId);
}
