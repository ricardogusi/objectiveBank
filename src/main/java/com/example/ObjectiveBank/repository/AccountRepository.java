package com.example.ObjectiveBank.repository;

import com.example.ObjectiveBank.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByAccountNumber(Integer accountNumber);
}
