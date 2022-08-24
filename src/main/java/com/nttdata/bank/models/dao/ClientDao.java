/**
 * 
 */
package com.nttdata.bank.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.models.Client;

/**
 * @author Roberto Ramos
 *
 */
@Repository
public interface ClientDao extends ReactiveMongoRepository<Client, String> {

}
