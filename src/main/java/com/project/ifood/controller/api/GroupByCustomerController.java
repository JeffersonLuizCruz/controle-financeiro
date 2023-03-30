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

import com.project.ifood.controller.dto.response.GroupResponseDTO;
import com.project.ifood.controller.mapper.GroupMapper;
import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.GroupCustomerService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/customers/{customerId}/groups")
public class GroupByCustomerController {

	private final GroupCustomerService groupCustomerService;
	
	private final CustomerService customerService;
	private final GroupMapper groupMapper;
	
	@GetMapping
	public ResponseEntity<List<GroupResponseDTO>> findAllByGroup(@PathVariable Long customerId){
		Customer customer = customerService.checkIfCustomerExists(customerId);
		
		List<GroupResponseDTO> dtoResponse = customer
				.getGroups()
				.stream()
				.map(dto -> groupMapper.toDTO(dto))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(dtoResponse);
	}
	
	@DeleteMapping("/{groupId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void disassociateRoles(@PathVariable Long customerId, @PathVariable Long groupId) {
		groupCustomerService.disassociate(groupId, customerId);
	}
	
	@PutMapping("/{groupId}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void associateRoles(@PathVariable Long customerId,@PathVariable Long groupId) {
		groupCustomerService.associate(groupId, customerId);
	}
}
