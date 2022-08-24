package com.nttdata.bank.models.dao.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD <T, V>  {
	Flux<T> findAll ();
	Mono<T> findById(V id);
	Mono<T> save(T obj,Boolean typeReg);
	Mono<Void> delete (T obj);

}
