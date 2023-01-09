package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

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

import com.project.ifood.controller.dto.request.KitchenDTO;
import com.project.ifood.controller.mapper.KitchenMapper;
import com.project.ifood.domain.model.Kitchen;
import com.project.ifood.domain.service.KitchenService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/kitchens")
public class KitchenController {
	
	private final KitchenService kitchenService;
	private final KitchenMapper kitchenMapper;
	

	@PostMapping
	public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kitchenService.save(kitchen));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen){
		return ResponseEntity.ok(kitchenService.update(id, kitchen));
	}
	
	@GetMapping
	public ResponseEntity<List<KitchenDTO>> findAll(){
		List<KitchenDTO> listKichenDTO = kitchenService.findAll().stream()
		.map(kitchen -> kitchenMapper.toDTO(kitchen))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(listKichenDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Kitchen> findById(@PathVariable Long id){
		return ResponseEntity.ok(kitchenService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		kitchenService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}