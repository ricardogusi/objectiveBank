package com.example.ObjectiveBank.controller;

import com.example.ObjectiveBank.model.Account;
import com.example.ObjectiveBank.model.Transaction;
import com.example.ObjectiveBank.repository.AccountRepository;
import com.example.ObjectiveBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Account> makeTransaction(@RequestBody Transaction transaction) {
        try {
            transactionService.makeTransaction(transaction);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
