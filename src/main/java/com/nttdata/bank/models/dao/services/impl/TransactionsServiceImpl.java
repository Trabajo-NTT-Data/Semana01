package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.Transactions;
import com.nttdata.bank.models.dao.TransactionsDao;
import com.nttdata.bank.models.dao.services.TransactionsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired 
	private TransactionsDao dao;
	@Override
	public Flux<Transactions> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Transactions> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Transactions> save(Transactions obj,Boolean typeReg) {
		return dao.save(obj);
	}

	@Override
	public Mono<Void> delete(Transactions obj) {
		return dao.delete(obj);
	}

}
