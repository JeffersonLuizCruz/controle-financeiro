package com.financial.porkinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.porkinho.domain.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long>{

}
