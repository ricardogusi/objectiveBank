package com.example.ObjectiveBank.controller;

import com.example.ObjectiveBank.model.Account;
import com.example.ObjectiveBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        if (accountRepository.findByAccountNumber(account.getAccountNumber()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Account newAccount = accountRepository.save(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getAccount(@RequestParam Integer accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            return new ResponseEntity<>("Conta não encontrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account.toString(), HttpStatus.OK);
    }
}
