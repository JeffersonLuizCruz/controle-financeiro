package com.project.ifood.domain.repositoy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	//Tipo de consulta para reduzir os select a base de dados.
	@Query("FROM Restaurant r JOIN FETCH r.kitchen LEFT JOIN FETCH r.paymentMethods LEFT JOIN FETCH r.owner LEFT JOIN FETCH r.products")
	//@Query("FROM Restaurant r JOIN FETCH r.kitchen")
	List<Restaurant> findAll();
	
	@Query("FROM Restaurant r JOIN FETCH r.kitchen LEFT JOIN FETCH r.paymentMethods LEFT JOIN FETCH r.owner LEFT JOIN FETCH r.products WHERE r.id = :id")
	Optional<Restaurant> findById(@Param("id") Long id);

}
