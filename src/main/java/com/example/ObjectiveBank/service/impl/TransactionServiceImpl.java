package com.example.ObjectiveBank.service.impl;

import com.example.ObjectiveBank.model.Account;
import com.example.ObjectiveBank.model.Transaction;
import com.example.ObjectiveBank.repository.AccountRepository;
import com.example.ObjectiveBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account makeTransaction(Transaction transaction) {
        Account account = accountRepository.findByAccountNumber(transaction.getAccountNumber());
        if (account == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return account;
        }
        float tax = 0.0F;
        switch (transaction.getPaymentMethod()) {
            case "D":
                tax = 0.03F;
                break;
            case "C":
                tax = 0.05F;
                break;
            case "P":
                tax = 0.0F;
                break;
            default:
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                return account;
        }
        float totalValue = transaction.getValue() * (1 + tax);
        if (account.getBalance() < totalValue) {
            throw new RuntimeException("Saldo insuficiente");
        }
        account.setBalance(account.getBalance() - totalValue);
        return accountRepository.save(account);
    }
}
