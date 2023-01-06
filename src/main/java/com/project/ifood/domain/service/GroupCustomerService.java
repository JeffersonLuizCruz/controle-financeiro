package com.project.ifood.domain.service;

public interface GroupCustomerService {

	void disassociate(Long groupId, Long customer);
	void associate(Long groupId, Long customer);
}
