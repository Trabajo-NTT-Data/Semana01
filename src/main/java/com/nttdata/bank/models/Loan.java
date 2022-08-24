package com.nttdata.bank.models;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Loan {
    @Id
    private String id;
    private String name;
    private Double maxAmount;
    private double balance;
    private double interes;
    private Date creationDate;
    private String clientID;    
}
