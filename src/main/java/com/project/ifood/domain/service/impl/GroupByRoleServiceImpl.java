package com.project.ifood.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Group;
import com.project.ifood.domain.model.Role;
import com.project.ifood.domain.service.GroupByRoleService;
import com.project.ifood.domain.service.GroupService;
import com.project.ifood.domain.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class GroupByRoleServiceImpl implements GroupByRoleService{

	private final GroupService groupService;
	private final RoleService roleService;
	
	@Transactional
	@Override
	public void disassociate(Long groupId, Long roleId) {
		Group groupEntity = groupService.checkIfGroupExists(groupId);
		Role roleEntity = roleService.checkIfRoleExists(roleId);
		
		/**
		 * Não foi realizado um update explicito do jpa ainda assim foi feito o upadate. Isso porque
		 * a injeção de dependência groupService e roleService junto com a anotação '@Transactional'
		 * está dentro do contexto do jpa.
		 * */
		
		groupEntity.getRoles().remove(roleEntity);
		
	}

	@Transactional
	@Override
	public void associate(Long groupId, Long roleId) {
		Group groupEntity = groupService.checkIfGroupExists(groupId);
		Role roleEntity = roleService.checkIfRoleExists(roleId);
		
		/**
		 * Não foi realizado um update explicito do jpa ainda assim foi feito o upadate. Isso porque
		 * a injeção de pedencia groupService e roleService junto com a anotação '@Transactional'
		 * está dentro do contexto do jpa.
		 * */
		
		groupEntity.getRoles().add(roleEntity);
		
	}

}
