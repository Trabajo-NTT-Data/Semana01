package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.HeadlineSignature;
import com.nttdata.bank.models.dao.HeadlineSignatureDao;
import com.nttdata.bank.models.dao.services.HeadlineSignatureService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class HeadlineSignatureServiceImpl implements HeadlineSignatureService {

	@Autowired 
	private HeadlineSignatureDao dao;
	@Override
	public Flux<HeadlineSignature> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<HeadlineSignature> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<HeadlineSignature> save(HeadlineSignature obj,Boolean typeReg) {
		return dao.save(obj);
	}

	@Override
	public Mono<Void> delete(HeadlineSignature obj) {
		return dao.delete(obj);
	}

}
