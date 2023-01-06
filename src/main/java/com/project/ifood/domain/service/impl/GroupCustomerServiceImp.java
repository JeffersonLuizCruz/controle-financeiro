package com.project.ifood.domain.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.model.ProfileGroup;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.GroupRoleService;
import com.project.ifood.domain.service.GroupService;

import lombok.RequiredArgsConstructor;


@Primary
@Service @RequiredArgsConstructor
public class GroupCustomerServiceImp implements GroupRoleService{

	private final CustomerService customerService;
	private final GroupService groupService;
	
	@Transactional
	@Override
	public void disassociateRole(Long groupId, Long customer) {
		Customer customerEntity = customerService.checkIfCustomerExists(customer);
		ProfileGroup groupEntity = groupService.checkIfGroupExists(groupId);
		
		customerEntity.getGroups().remove(groupEntity);
	}

	@Transactional
	@Override
	public void associateRole(Long groupId, Long customer) {
		Customer customerEntity = customerService.checkIfCustomerExists(customer);
		ProfileGroup groupEntity = groupService.checkIfGroupExists(groupId);
		
		customerEntity.getGroups().add(groupEntity);
		
	}

}
