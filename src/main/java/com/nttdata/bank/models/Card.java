package com.nttdata.bank.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bank.models.enums.CardColor;
import com.nttdata.bank.models.enums.TransactionsType;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "card")
@Data
public class Card {
    @Id
    private String id;
    private String cardHolder;
    private TransactionsType type;
    private CardColor cardColor;
    private String number;
    private  int  cvv;
    /*private Date fromDate;
    private Date truDate;*/
    private Date creationDate ;
    private Boolean esActiva=true;
    private String clientID;
    private String accountID;
}
