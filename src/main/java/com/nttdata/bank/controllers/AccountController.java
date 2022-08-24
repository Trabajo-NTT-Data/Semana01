package com.nttdata.bank.controllers;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bank.models.Account;
import com.nttdata.bank.models.dao.services.AccountService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService service;
	@GetMapping
	public Mono<ResponseEntity<Flux<Account>>> lista(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll())
				);
	}
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Account>> ver(@PathVariable String id){
		return service.findById(id).map(p -> ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ResponseEntity<Account>> crear(@RequestBody Account account){
		
		if(account.getCreationDate()==null) {
			account.setCreationDate(new Date());
		}
		
		return service.save(account,true).map(p-> ResponseEntity
				.created(URI.create("/api/accounts/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p)
				);
		
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> eliminar(@PathVariable String id){
		return service.findById(id).flatMap(p ->{
			return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	public Mono<ResponseEntity<Account>> editar(@RequestBody Account account){
		return service.findById(account.getId()).flatMap(p -> {
			return service.save(account,false);
		}).map(p->ResponseEntity.created(URI.create("/api/productos/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
		.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
}
