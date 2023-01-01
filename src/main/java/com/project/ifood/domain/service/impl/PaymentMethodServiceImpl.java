package com.project.ifood.domain.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ifood.domain.model.PaymentMethod;
import com.project.ifood.domain.repositoy.PaymentMethodRespository;
import com.project.ifood.domain.service.PaymentMethodService;
import com.project.ifood.domain.service.exception.ConstraintViolationService;
import com.project.ifood.domain.service.exception.NotFoundExceptionService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

	private final PaymentMethodRespository paymentMethodRespository;
	
	public PaymentMethodServiceImpl(PaymentMethodRespository paymentMethodRespository) {
		this.paymentMethodRespository = paymentMethodRespository;
	}
	
    private final String NOT_FOUND_MESSAGE = "O tipo de pagamento de código '%d' não encontrado.";
    private final String CONSTRAINT_VALIDATION_MESSAGE = "O tipo de pagamento de código '%d' não pode ser removida, pois está em uso";

	
	@Transactional
	@Override
	public PaymentMethod save(PaymentMethod paymentMethod) {
		
		return paymentMethodRespository.save(paymentMethod);
	}
	
	@Transactional
	@Override
	public PaymentMethod update(Long id, PaymentMethod paymentMethod) {
		PaymentMethod paymentMethodEntity = checkIfStateExists(id);
		return paymentMethodRespository.save(paymentMethodEntity);
	}

	@Override
	public List<PaymentMethod> findAll() {
		return paymentMethodRespository.findAll();
	}

	@Override
	public PaymentMethod findById(Long id) {
		return checkIfStateExists(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {

		try {
			PaymentMethod paymentMethodEntity = checkIfStateExists(id);
			paymentMethodRespository.delete(paymentMethodEntity);
			paymentMethodRespository.flush();
		} catch (DataIntegrityViolationException | ConstraintViolationException e) {
			throw new ConstraintViolationService(String.format(CONSTRAINT_VALIDATION_MESSAGE, id));
		}
	}
		

	@Override
	public PaymentMethod checkIfStateExists(Long id) {
		return paymentMethodRespository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionService(String.format(NOT_FOUND_MESSAGE, id)));
	}

}