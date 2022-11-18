package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.PaymentMethod;

public interface PaymentMethodService {
	
	PaymentMethod save(PaymentMethod paymentMethod);
	PaymentMethod update(PaymentMethod paymentMethod);
	List<PaymentMethod> findAll();
	PaymentMethod findById(Long id);
	void delete(Long id);
}
