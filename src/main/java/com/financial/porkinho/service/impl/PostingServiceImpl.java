package com.financial.porkinho.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financial.porkinho.domain.model.Posting;
import com.financial.porkinho.repository.PostingRepository;
import com.financial.porkinho.service.PostingService;

@Service
public class PostingServiceImpl implements PostingService{

	private final PostingRepository postingRepository;
	
	public PostingServiceImpl(PostingRepository postingRepository) {
		this.postingRepository = postingRepository;
	}
	
	@Override
	public Posting save(Posting posting) {
		return postingRepository.saveAndFlush(posting);
	}

	@Override
	public Posting update(Posting posting) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posting> findAll() {
		return postingRepository.findAll();
	}

	@Override
	public Posting findById(Long id) {
		return verifyIfExistsPosting(id);
	}
	
	private Posting verifyIfExistsPosting(Long id){
		return postingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("message test"));
	}
}
