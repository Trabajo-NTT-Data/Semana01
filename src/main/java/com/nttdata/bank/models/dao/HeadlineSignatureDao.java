package com.nttdata.bank.models.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.models.HeadlineSignature;
@Repository
public interface HeadlineSignatureDao extends ReactiveMongoRepository<HeadlineSignature, String> {

}
