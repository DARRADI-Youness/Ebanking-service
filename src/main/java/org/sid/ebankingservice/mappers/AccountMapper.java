package org.sid.ebankingservice.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.ebankingservice.dto.BankAccountRequestDTO;
import org.sid.ebankingservice.dto.BankAccountResponseDTO;
import org.sid.ebankingservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
    BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
    BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
    return  bankAccountResponseDTO;
}
}
