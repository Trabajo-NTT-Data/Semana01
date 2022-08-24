package com.nttdata.bank.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bank.models.enums.TransactionsType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loan")
@Data
public class Transactions {
    @Id
    private String id;
    @Valid
    private TransactionsType type;
    private Double amount;
    private String description;
    private Date creationDate;
    private String accountID;
}
