package com.nttdata.bank.models;
import com.nttdata.bank.models.enums.TypeAccounts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountGrupo {
     private TypeAccounts typeAccounts;
    	 private int total;
}
