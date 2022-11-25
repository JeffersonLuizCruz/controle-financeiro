package com.financial.ifood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financial.ifood.domain.model.PaymentMethod;

@Repository
public interface PaymentMethodRespository extends JpaRepository<PaymentMethod, Long>{

}
