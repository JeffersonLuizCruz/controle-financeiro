package com.project.ifood.domain.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("FROM Product WHERE restaurant.id = :restaurantId AND id = :productId")
	Optional<Product> findByIdProduct(@Param("restaurantId") Long restaurantId,@Param("productId") Long productId);
}
