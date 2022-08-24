package com.nttdata.bank.models;



import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.nttdata.bank.models.enums.TypeAccounts;
import com.nttdata.bank.models.enums.TypeMove;

import org.springframework.data.annotation.Id;



import java.util.Date;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Account {
    @Id
	@NotEmpty
    private String id;
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate ;
    private double balance;
    private boolean active = true;
    private double comisionMant=10;
    @Valid
    private TypeAccounts typeAccounts;
    @Valid
    private TypeMove typeMove=TypeMove.L;
    private int moveMax=0;
    private String clientID;
}

