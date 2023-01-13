package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.model.Group;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.GroupCustomerService;
import com.project.ifood.domain.service.GroupService;

import lombok.RequiredArgsConstructor;


@Service @RequiredArgsConstructor
public class GroupByCustomerServiceImp implements GroupCustomerService{

	private final CustomerService customerService;
	private final GroupService groupService;
	
	@Transactional
	@Override
	public void disassociate(Long groupId, Long customer) {
		Customer customerEntity = customerService.checkIfCustomerExists(customer);
		Group groupEntity = groupService.checkIfGroupExists(groupId);
		
		customerEntity.getGroups().remove(groupEntity);
	}

	@Transactional
	@Override
	public void associate(Long groupId, Long customer) {
		Customer customerEntity = customerService.checkIfCustomerExists(customer);
		Group groupEntity = groupService.checkIfGroupExists(groupId);
		
		customerEntity.getGroups().add(groupEntity);
		
	}

}
