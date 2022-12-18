package com.financial.ifood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.ifood.domain.model.PaymentMethod;
import com.financial.ifood.service.PaymentMethodService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

	@Transactional
	@Override
	public PaymentMethod save(PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public PaymentMethod update(Long id, PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentMethod> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMethod findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
