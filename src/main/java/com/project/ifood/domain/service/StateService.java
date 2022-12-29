package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.State;

public interface StateService {
	
	State save(State state);
	State update(Long id, State state);
	List<State> findAll();
	State findById(Long id);
	void deleteById(Long id);
	State checkIfStateExists(Long id);
}
