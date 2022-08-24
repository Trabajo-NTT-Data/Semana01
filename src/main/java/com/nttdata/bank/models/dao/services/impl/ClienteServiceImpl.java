package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.Client;
import com.nttdata.bank.models.dao.ClientDao;
import com.nttdata.bank.models.dao.services.ClientService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClientService {

	@Autowired 
	private ClientDao dao;
	@Override
	public Flux<Client> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Client> save(Client client,Boolean typeReg) {
		return dao.save(client);
	}

	@Override
	public Mono<Void> delete(Client client) {
		return dao.delete(client);
	}

}
