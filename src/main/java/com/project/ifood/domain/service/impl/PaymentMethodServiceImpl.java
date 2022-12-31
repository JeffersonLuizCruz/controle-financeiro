package com.project.ifood.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.service.PaymentMethodService;

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