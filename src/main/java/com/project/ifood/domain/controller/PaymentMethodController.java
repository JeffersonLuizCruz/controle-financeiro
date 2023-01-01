package com.project.ifood.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.service.PaymentMethodService;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

	private final PaymentMethodService paymentMethodService;

	public PaymentMethodController(PaymentMethodService paymentMethodService) {
		this.paymentMethodService = paymentMethodService;
	}
	
	@PostMapping
	public ResponseEntity<PaymentMethod> save(@RequestBody PaymentMethod paymentMethod){
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentMethodService.save(paymentMethod));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaymentMethod> update(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod){
		return ResponseEntity.ok(paymentMethodService.update(id, paymentMethod));
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentMethod>> findAll(){
		return ResponseEntity.ok(paymentMethodService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentMethod> findById(@PathVariable Long id){
		
		return ResponseEntity.ok(paymentMethodService.findById(id));
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(Long id) {
		paymentMethodService.deleteById(id);
	}
}
