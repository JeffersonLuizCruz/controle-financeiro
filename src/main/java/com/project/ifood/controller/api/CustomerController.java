package com.project.ifood.controller.api;

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

import com.project.ifood.controller.dto.input.CustomerPasswordInput;
import com.project.ifood.controller.dto.request.CustomerDTO;
import com.project.ifood.controller.dto.request.CustomerRequestDTO;
import com.project.ifood.controller.dto.response.CustomerResponseDTO;
import com.project.ifood.controller.mapper.CustomerMapper;
import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

	private final CustomerService customerService;
	private final CustomerMapper customerMapper;
	
	
	@PostMapping
	public ResponseEntity<CustomerResponseDTO> save(@RequestBody @Valid CustomerRequestDTO resume){
		Customer modelCustomer = customerMapper.toModel(resume);
		Customer customerEntity = customerService.save(modelCustomer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(customerEntity));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CustomerDTO dto){
		Customer modelCustomer = customerMapper.toModel(dto);
		
		Customer customerEntity = customerService.update(id, modelCustomer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toDTO(customerEntity));
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerResponseDTO>> findAll(){
		List<CustomerResponseDTO> listCustomerDTO = customerService.findAll().stream()
		.map(customer -> customerMapper.toDTO(customer))
		.collect(Collectors.toList());
		
		System.out.println(listCustomerDTO);
		
		return ResponseEntity.ok().body(listCustomerDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id){
		Customer customerEntity = customerService.findById(id);
		return ResponseEntity.ok(customerMapper.toDTO(customerEntity));
	}
	
	@DeleteMapping("/{id}") @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		customerService.deleteById(id);		
	}
	
	// TODO implementação de serviço faltando
	@PutMapping("/{id}/senha")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void alterarSenha(@PathVariable Long id, @RequestBody @Valid CustomerPasswordInput password) {
		customerService.updatePassword(id, password.getCurrentPassword(), password.getCurrentPassword());
	}
}
