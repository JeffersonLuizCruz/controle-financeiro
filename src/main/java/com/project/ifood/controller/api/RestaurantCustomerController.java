package com.project.ifood.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ifood.controller.dto.response.CustomerResponseDTO;
import com.project.ifood.controller.mapper.CustomerMapper;
import com.project.ifood.domain.model.Restaurant;
import com.project.ifood.domain.service.RestaurantCustomerService;
import com.project.ifood.domain.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/restaurants/{restaurantId}/owners")
public class RestaurantCustomerController {

	private final RestaurantService restaurantService;
	private final CustomerMapper customerMappger;
	private final RestaurantCustomerService restaurantCustomerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerResponseDTO>> findByCustomerAll(@PathVariable Long restaurantId){
		Restaurant restaurantEntity = restaurantService.checkIfRestaurantExists(restaurantId);
		
		List<CustomerResponseDTO> listCustomerDTO = restaurantEntity
		.getOwner()
		.stream()
		.map(customer -> customerMappger.toDTO(customer))
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(listCustomerDTO);
	}
	
	
	@DeleteMapping("/{customerId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void disassociate(@PathVariable Long restaurantId, @PathVariable Long customerId) {
		restaurantCustomerService.disassociate(restaurantId, customerId);
	}
	
	@PutMapping("/{customerId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void associate(@PathVariable Long restaurantId, @PathVariable Long customerId) {
		restaurantCustomerService.associate(restaurantId, customerId);
	}
}
