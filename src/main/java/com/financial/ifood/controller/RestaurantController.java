package com.financial.ifood.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.financial.ifood.domain.model.Restaurant;
import com.financial.ifood.service.RestaurantService;



@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	@PostMapping
	public ResponseEntity<Restaurant> save(@RequestBody @Valid Restaurant restaurant){
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.save(restaurant));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant){
		return ResponseEntity.ok(restaurantService.update(id, restaurant));
	}
	
	@GetMapping
	public ResponseEntity<List<Restaurant>> findAll(){
		return ResponseEntity.ok(restaurantService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable Long id){
		return ResponseEntity.ok(restaurantService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		restaurantService.deleteById(id);
		return ResponseEntity.notFound().build();
	}
 
}
