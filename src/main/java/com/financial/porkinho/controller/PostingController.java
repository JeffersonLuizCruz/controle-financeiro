package com.financial.porkinho.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financial.porkinho.domain.model.Posting;
import com.financial.porkinho.service.PostingService;

@RestController
@RequestMapping("/postings")
public class PostingController {

	private final PostingService postingService;
	
	public PostingController(PostingService postingService) {
		this.postingService = postingService;
	}
	
	@PostMapping
	public ResponseEntity<Posting> save(@RequestBody Posting posting){
		return ResponseEntity.status(HttpStatus.CREATED).body(postingService.save(posting));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Posting> findById(@PathVariable Long id){
		return ResponseEntity.ok(postingService.findById(id));		
	}
	
	@GetMapping
	public ResponseEntity<List<Posting>> findAll(){
		return ResponseEntity.ok(postingService.findAll());		
	}
}
