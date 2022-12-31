package com.project.ifood.domain.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.domain.controller.mapper.RestaurantMapper;
import com.project.ifood.domain.controller.mapper.dto.request.RestaurantRequestDTO;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantService restaurantService;
	private final RestaurantMapper mapperRestaurantMapper;

	public RestaurantController(RestaurantService restaurantService, RestaurantMapper mapperRestaurantMapper) {
		this.restaurantService = restaurantService;
		this.mapperRestaurantMapper = mapperRestaurantMapper;
	}
	
	@PostMapping
	public ResponseEntity<Restaurant> save(@RequestBody @Valid Restaurant restaurant){
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.save(restaurant));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant restaurant){
		return ResponseEntity.ok(restaurantService.update(id, restaurant));
	}
	
	// TODO resolver problema N+1
	@GetMapping
	public ResponseEntity<List<RestaurantRequestDTO>> findAll(){
		return ResponseEntity.ok(restaurantService.findAll()
				.stream()
				.map(restaurant -> mapperRestaurantMapper.toDTO(restaurant))
				.collect(Collectors.toList()));
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
	
	@PutMapping("/{restaurantId}/active")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void active(@PathVariable Long restaurantId) {
		restaurantService.isActive(restaurantId);
	}
	
	@DeleteMapping("/{restaurantId}/disable")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void disable(@PathVariable Long restaurantId) {
		restaurantService.isDisable(restaurantId);
	}
 
}
