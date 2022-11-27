package com.financial.ifood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.financial.ifood.domain.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query("FROM Restaurant r JOIN FETCH r.kitchen LEFT JOIN FETCH r.paymentMethods")
	List<Restaurant> findAll();

}
