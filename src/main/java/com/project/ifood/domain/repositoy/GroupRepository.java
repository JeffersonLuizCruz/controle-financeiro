package com.project.ifood.domain.repositoy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
	List<Group> findAll();
	Optional<Group> findById(@Param("id") Long id);
}
