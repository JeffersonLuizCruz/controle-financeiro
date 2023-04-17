package com.project.ifood.domain.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.ProductPhoto;

@Repository
public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long>{

	@Query("FROM ProductPhoto pp JOIN pp.product p WHERE p.id = :productId AND p.restaurant.id = :restaurantId")
	Optional<ProductPhoto> findByProductAndRestaurant(Long productId, Long restaurantId);
}
