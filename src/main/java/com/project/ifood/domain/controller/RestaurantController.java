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
import com.project.ifood.domain.controller.mapper.dto.RestaurantDTO;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	private final RestaurantService restaurantService;
	private final RestaurantMapper restaurantMapper;

	public RestaurantController(RestaurantService restaurantService, RestaurantMapper restaurantMapper) {
		this.restaurantService = restaurantService;
		this.restaurantMapper = restaurantMapper;
	}
	
	@PostMapping
	public ResponseEntity<RestaurantDTO> save(@RequestBody @Valid RestaurantDTO dto){
		Restaurant restaurant = restaurantMapper.toModel(dto);
		restaurantService.save(restaurant);
		
		RestaurantDTO restaurantDTO = restaurantMapper.toDTO(restaurant);
		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RestaurantDTO> update(@PathVariable Long id, @RequestBody RestaurantDTO dto){
		Restaurant restaurant = restaurantMapper.toModel(dto);
		restaurantService.update(id, restaurant);
		
		RestaurantDTO restaurantDTO = restaurantMapper.toDTO(restaurant);
		return ResponseEntity.ok(restaurantDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> findAll(){
		return ResponseEntity.ok(restaurantService.findAll()
				.stream()
				.map(restaurant -> restaurantMapper.toDTO(restaurant))
				.collect(Collectors.toList()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDTO> findById(@PathVariable Long id){
		Restaurant restaurantEntity = restaurantService.findById(id);
		return ResponseEntity.ok(restaurantMapper.toDTO(restaurantEntity));
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
	
	@DeleteMapping("/{restaurantId}/inactive")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void inactive(@PathVariable Long restaurantId) {
		restaurantService.isDisable(restaurantId);
	}
 
}
