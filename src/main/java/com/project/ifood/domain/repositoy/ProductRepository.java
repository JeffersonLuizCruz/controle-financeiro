package com.project.ifood.domain.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
