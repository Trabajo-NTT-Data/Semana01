package com.nttdata.bank.models;



import org.springframework.data.mongodb.core.mapping.Document;

import com.nttdata.bank.models.enums.TypeAccounts;
import com.nttdata.bank.models.enums.TypeClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "confiProduct")
@Data
public class ConfiProduct {
	private String id;
	private TypeClient client;
	private TypeAccounts accounts;
	private Integer max;
}
