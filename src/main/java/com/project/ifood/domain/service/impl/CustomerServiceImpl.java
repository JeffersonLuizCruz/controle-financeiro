package com.project.ifood.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.Customer;
import com.project.ifood.domain.repositoy.CustomerRepository;
import com.project.ifood.domain.service.CustomerService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private final String CONSTRAINT_VALIDATION_MESSAGE = "Usuário de código '%d' não pode ser removida, pois está em uso";
	private final String NOT_FOUND_MESSAGE = "Usuário de código '%d' não encontrado.";
	private final String USER_EXIST_MESSAGE = "Usuário com email '%s' já existe.";
	
	@Transactional
	@Override
	public Customer save(Customer customer) {
		Optional<Customer> customerEntity = customerRepository.findByEmail(customer.getEmail());

		if (customerEntity.isPresent() && !customerEntity.get().equals(customer)) {
			throw new ConstraintViolationService(String.format(USER_EXIST_MESSAGE, customer.getEmail()));
		}
		return customerRepository.save(customer);
	}

	@Transactional
	@Override
	public Customer update(Long id, Customer customer) {
		Customer customerEntity = checkIfCustomerExists(id);
		
		customer.setId(id);
		customer.setCreateAt(customerEntity.getCreateAt());
		customer.setPassword(customerEntity.getPassword());
		
		Optional<Customer> customerExist = customerRepository.findByEmail(customer.getEmail());

		if (customerExist.isPresent() && !customerExist.get().equals(customer)) {
			throw new ConstraintViolationService(String.format(USER_EXIST_MESSAGE, customer.getEmail()));
		}
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return checkIfCustomerExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		try {
			Customer customerEntity = checkIfCustomerExists(id);
			customerRepository.delete(customerEntity);
			customerRepository.flush();
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}

	@Override
	public Customer checkIfCustomerExists(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}
	
	@Transactional
	@Override
	public void updatePassword(Long id, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

}
