package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.Loan;
import com.nttdata.bank.models.dao.LoanDao;
import com.nttdata.bank.models.dao.services.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class LoanServiceImpl implements LoanService {

	@Autowired 
	private LoanDao dao;
	@Override
	public Flux<Loan> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Loan> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Loan> save(Loan obj,Boolean typeReg) {
		return dao.save(obj);
	}

	@Override
	public Mono<Void> delete(Loan obj) {
		return dao.delete(obj);
	}

}
