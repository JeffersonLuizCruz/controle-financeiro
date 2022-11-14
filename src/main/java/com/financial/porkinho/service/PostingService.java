package com.financial.porkinho.service;

import java.util.List;

import com.financial.porkinho.domain.model.Posting;

public interface PostingService {

	Posting save(Posting posting);
	Posting update(Posting posting);
	List<Posting> findAll();
	Posting findById(Long id);
}
