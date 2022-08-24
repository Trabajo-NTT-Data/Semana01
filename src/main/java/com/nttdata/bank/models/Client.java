package com.nttdata.bank.models;

import java.util.Date;


import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.format.annotation.DateTimeFormat;

import com.nttdata.bank.models.enums.TypeClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Document
@Data
public class Client {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
   // private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
    @Valid
    private TypeClient typeClient;
          
}


