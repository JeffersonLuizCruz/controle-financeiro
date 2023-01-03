package com.project.ifood.domain.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByEmail(String email);
}
