package com.example.ObjectiveBank.service;

import com.example.ObjectiveBank.model.Account;
import com.example.ObjectiveBank.model.Transaction;

public interface TransactionService {

    Account makeTransaction(Transaction transaction);

}
