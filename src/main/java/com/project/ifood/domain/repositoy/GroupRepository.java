package com.project.ifood.domain.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
}
