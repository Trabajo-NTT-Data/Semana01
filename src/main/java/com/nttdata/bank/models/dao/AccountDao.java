package com.nttdata.bank.models.dao;




import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.models.Account;

import reactor.core.publisher.Flux;



@Repository
public interface AccountDao extends ReactiveMongoRepository<Account, String> {
	
	 Flux<Account> findByClientID(String clientID); 
}