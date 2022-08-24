package com.nttdata.bank.models.dao.services.impl;


import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nttdata.bank.models.Account;

import com.nttdata.bank.models.dao.AccountDao;
import com.nttdata.bank.models.dao.services.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import com.nttdata.bank.models.enums.TypeMove;


@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired 
	private AccountDao dao;
	@Override
	public Flux<Account> findAll() {
		return dao.findAll();
		
	}

	@Override
	public Mono<Account> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Mono<Account> save(Account account,Boolean typeReg) {
		if (typeReg) 
		{
			switch (account.getTypeAccounts()) {
	        case AHORRO	        :
	            account.setTypeMove(TypeMove.M);
	            account.setMoveMax(6);
	            break;
	        case  CORRIENTE:
	        	account.setComisionMant(10);
	        	account.setTypeMove(TypeMove.L);
	            break;
	        case PLAZOFIJO:
	        	account.setTypeMove(TypeMove.D);
	            account.setMoveMax(25);
	            break;
			}
			
		}
	          Flux<Account> grupoList = dao.findByClientID(account.getClientID());
	          
	          /* grupoList.groupBy(Account::getTypeAccounts)
	        		  .flatMap(acc -> acc
	        				  .collectList()
	        				  .map(lista -> new Movtipo(acc.key(),lista)

	        					)
	        				  
	        				  )*/
	        		  //.doOnNext(count->log.info(count.toString()));
	        		  
	          
	         /*.stream()
             .collect(Collectors.groupingBy(Account::getTypeAccounts,
                     Collectors.counting())	;*/  
	      //Flux<Object> test = grupoList.groupBy(Account::getTypeAccounts).flatMap(w -> w.count().map(c -> Tuples.of(w.key(), c)));
	      //Map<TypeAccounts, Long> ahorro = grupoList.toStream().collect(Collectors.groupingBy(Account::getTypeAccounts,Collectors.counting()));
	    		 //.groupBy(Account -> Instance.getTypeAccounts());
	      
	       ///grupoList.forEach(System.out::println);
	          
	       //System.out.println(grupoList.getClass());
	     
		return dao.save(account);
	}

	@Override
	public Mono<Void> delete(Account account) {
		return dao.delete(account);
	}

}
