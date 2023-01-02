package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.ProfileGroup;

public interface GroupService {

	ProfileGroup save(ProfileGroup group);
	ProfileGroup update(Long id, ProfileGroup group);
	List<ProfileGroup> findAll();
	ProfileGroup findById(Long id);
	void deleteById(Long id);
	ProfileGroup checkIfGroupExists(Long id);
}
