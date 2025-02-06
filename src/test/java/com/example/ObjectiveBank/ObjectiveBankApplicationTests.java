package com.example.ObjectiveBank;

import com.example.ObjectiveBank.model.Account;
import com.example.ObjectiveBank.model.Transaction;
import com.example.ObjectiveBank.repository.AccountRepository;
import com.example.ObjectiveBank.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void testRealizarTransacaoComSaldoSuficiente() {
        Account account = new Account();
        account.setAccountNumber(123);
        account.setBalance(100.0F);
        Transaction transaction = new Transaction();
        transaction.setPaymentMethod("D");
        transaction.setAccountNumber(123);
        transaction.setValue(10.0F);
        Mockito.when(accountRepository.findByAccountNumber(123)).thenReturn(account);
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(account);
        Account updatedAccount = transactionService.makeTransaction(transaction);
        assertEquals(89.7F, updatedAccount.getBalance());
    }

    @Test
    public void testRealizarTransacaoSemSaldoSuficiente() {
        Account account = new Account();
        account.setAccountNumber(123);
        account.setBalance(100.0F);
        Transaction transaction = new Transaction();
        transaction.setPaymentMethod("D");
        transaction.setAccountNumber(123);
        transaction.setValue(300.0F);
        Mockito.when(accountRepository.findByAccountNumber(123)).thenReturn(account);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            transactionService.makeTransaction(transaction);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

}

