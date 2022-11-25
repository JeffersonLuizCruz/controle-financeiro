package com.financial.ifood.controller;

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

import com.financial.ifood.domain.model.Kitchen;
import com.financial.ifood.service.KitchenService;

@RestController
@RequestMapping("kitchens")
public class KitchenController {
	
	private final KitchenService kitchenService;
	
	public KitchenController(KitchenService kitchenService) {
		this.kitchenService = kitchenService;
	}

	@PostMapping
	public ResponseEntity<Kitchen> save(@RequestBody Kitchen kitchen) {
		return ResponseEntity.status(HttpStatus.CREATED).body(kitchenService.save(kitchen));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen){
		return ResponseEntity.ok(kitchenService.update(id, kitchen));
	}
	
	@GetMapping
	public ResponseEntity<List<Kitchen>> findAll(){
		return ResponseEntity.ok(kitchenService.findAll());
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
