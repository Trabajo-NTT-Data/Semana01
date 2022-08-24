package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.ClientLoans;
import com.nttdata.bank.models.dao.ClientLoansDao;
import com.nttdata.bank.models.dao.services.ClientLoansService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ClientLoansServiceImpl implements ClientLoansService {

	@Autowired 
	private ClientLoansDao dao;
	@Override
	public Flux<ClientLoans> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<ClientLoans> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<ClientLoans> save(ClientLoans obj,Boolean typeReg) {
		return dao.save(obj);
	}

	@Override
	public Mono<Void> delete(ClientLoans obj) {
		return dao.delete(obj);
	}

}
