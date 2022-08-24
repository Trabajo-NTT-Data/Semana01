package com.nttdata.bank.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class ClientLoans {
    @Id
    private String id;
    private Double amount;
    private int payments;
    private Date creationDate;
    private String clientID;
    private String loanID;
}
