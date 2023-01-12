package com.project.ifood.domain.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query("FROM Order o JOIN FETCH o.restaurant r JOIN FETCH r.kitchen JOIN FETCH o.paymentMethod JOIN FETCH o.customer")
	List<Order> findAll();
}
