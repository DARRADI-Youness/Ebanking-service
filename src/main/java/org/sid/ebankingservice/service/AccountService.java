package org.sid.ebankingservice.service;

import org.sid.ebankingservice.dto.BankAccountRequestDTO;
import org.sid.ebankingservice.dto.BankAccountResponseDTO;
import org.sid.ebankingservice.entities.BankAccount;
import org.sid.ebankingservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
