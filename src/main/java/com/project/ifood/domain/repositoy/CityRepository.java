package com.project.ifood.domain.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query("FROM City c JOIN FETCH c.state")
	List<City> findAll();
}
