package com.nttdata.bank.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.models.Loan;
@Repository
public interface LoanDao extends ReactiveMongoRepository<Loan, String> {

}
