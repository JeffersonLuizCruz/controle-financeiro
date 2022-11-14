package com.financial.porkinho.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.porkinho.domain.model.Institution;
import com.financial.porkinho.service.InstitutionService;

@RestController
@RequestMapping("/institutions")
public class InstitutionController {

	private final InstitutionService institutionService;
	
	public InstitutionController(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	
	@PostMapping
	public ResponseEntity<Institution> save(@RequestBody Institution institution){
		return ResponseEntity.ok(institutionService.save(institution));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Institution> update(@PathVariable Long id, @RequestBody Institution institution){
		return ResponseEntity.ok(institutionService.update(id, institution));
	}
	
	@GetMapping
	public ResponseEntity<List<Institution>> findAll(){
		return ResponseEntity.ok(institutionService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Institution> findById(@PathVariable Long id){
		return ResponseEntity.ok(institutionService.findById(id));
	}
}
