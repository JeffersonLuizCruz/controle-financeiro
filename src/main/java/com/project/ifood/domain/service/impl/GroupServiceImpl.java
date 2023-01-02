package com.project.ifood.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.Group;
import com.project.ifood.domain.repositoy.GroupRepository;
import com.project.ifood.domain.service.GroupService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

	private final GroupRepository groupRepository;
	

	@Override
	public Group save(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group update(Long id, Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group checkIfStateExists(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
