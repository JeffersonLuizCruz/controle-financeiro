package com.project.ifood.domain.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ifood.domain.model.PaymentMethod;

@Repository
public interface PaymentMethodRespository extends JpaRepository<PaymentMethod, Long>{

}