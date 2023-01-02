package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Group;

public interface GroupService {

	Group save(Group group);
	Group update(Long id, Group group);
	List<Group> findAll();
	Group findById(Long id);
	void deleteById(Long id);
	Group checkIfStateExists(Long id);
}
