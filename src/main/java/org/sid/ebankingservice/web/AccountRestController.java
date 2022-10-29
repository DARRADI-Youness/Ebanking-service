package org.sid.ebankingservice.web;

import org.sid.ebankingservice.entities.BankAccount;
import org.sid.ebankingservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;


    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
@PostMapping("/bankAccounts")
public BankAccount save(@RequestBody BankAccount bankAccount){
  return bankAccountRepository.save(bankAccount);
}
    @PostMapping("/bankAccounts/{id}")
    public BankAccount save(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        if (bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}