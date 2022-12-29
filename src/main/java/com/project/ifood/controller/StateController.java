package com.project.ifood.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.mapper.StateMapper;
import com.project.ifood.controller.mapper.dto.request.StateRequestDTO;
import com.project.ifood.domain.model.State;
import com.project.ifood.service.StateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("states")
public class StateController {

	private final StateService stateService;
	private final StateMapper stateMapper;

	public StateController(StateService stateService, StateMapper stateMapper){
		this.stateService = stateService;
		this.stateMapper = stateMapper;
	}
	@PostMapping
	public ResponseEntity<State> save(@RequestBody @Valid StateRequestDTO dto){
		State state = stateMapper.toModel(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.save(state));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<State> update(@PathVariable Long id, @RequestBody @Valid StateRequestDTO dto){
		State state = stateMapper.toModel(dto);
		return ResponseEntity.ok(stateService.update(id, state));
	}
	
	@GetMapping
	public ResponseEntity<List<State>> findAll(){
		return ResponseEntity.ok(stateService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<State> findById(@PathVariable Long id){
		return ResponseEntity.ok(stateService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		stateService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
