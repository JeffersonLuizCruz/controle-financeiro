package com.project.ifood.domain.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
