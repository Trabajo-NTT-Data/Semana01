package com.nttdata.bank.models.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.models.Card;
import com.nttdata.bank.models.dao.CardDao;
import com.nttdata.bank.models.dao.services.CardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {
	@Autowired 
	private CardDao dao;
	@Override
	public Flux<Card> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Card> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Card> save(Card obj,Boolean typeReg) {
		return dao.save(obj);
	}

	@Override
	public Mono<Void> delete(Card obj) {
		return dao.delete(obj);
	}

}
