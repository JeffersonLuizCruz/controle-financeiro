package com.project.ifood.domain.service;

import java.util.List;

import com.project.ifood.domain.model.Customer;

public interface CustomerService {
	
	Customer save(Customer customer);
	Customer update(Long id, Customer customer);
	List<Customer> findAll();
	Customer findById(Long id);
	void deleteById(Long id);
	Customer checkIfCustomerExists(Long id);

}
