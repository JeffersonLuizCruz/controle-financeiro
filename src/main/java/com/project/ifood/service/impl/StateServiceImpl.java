package com.project.ifood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.project.ifood.domain.model.State;
import com.project.ifood.repository.StateRepository;
import com.project.ifood.service.StateService;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    private final String CONSTRAINT_VALIDATION_MESSAGE = "Estado de código '%d' não pode ser removida, pois está em uso";
    private final String NOT_FOUND_MESSAGE = "Estado de código '%d' não encontrado.";
    
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

		try {
			State stateEntity = checkIfStateExists(id);
			stateRepository.delete(stateEntity);
		}catch (DataIntegrityViolationException e){
			//throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
    }

    @Override
    public State checkIfStateExists(Long id) {
        return stateRepository.findById(id).orElseThrow(() ->
                new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
    }

}
