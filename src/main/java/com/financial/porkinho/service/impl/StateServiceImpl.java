package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.State;
import com.financial.porkinho.repository.StateRepository;
import com.financial.porkinho.service.StateService;

@Service
public class StateServiceImpl implements StateService{

	private StateRepository stateRepository;
	
	public StateServiceImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

	@Override
	public State update(Long id, State state) {
		checkIfStateExists(id);
		state.setId(id);
		return stateRepository.save(state);
	}

	@Override
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	@Override
	public State findById(Long id) {
		return checkIfStateExists(id);
	}

	@Override
	public void deleteById(Long id) {
		State stateEntity = checkIfStateExists(id);
		stateRepository.delete(stateEntity);
	}
	
	@Override
	public State checkIfStateExists(Long id) {
		return stateRepository.findById(id).orElseThrow(() -> new RuntimeException("TODO - implement Exception Handler"));
	}

}
