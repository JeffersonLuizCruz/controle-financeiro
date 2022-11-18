package com.financial.porkinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.porkinho.domain.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
