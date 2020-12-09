package com.prime.pack.service;

import com.prime.pack.domain.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> getBankAccounts();

    List<BankAccount> getBankAccountsClient(Long idClient);

    BankAccount getBankAccountClient(Long id);

    BankAccount updateBankAccount(Long id, BankAccount bankAccount);

    BankAccount addBankAccount(BankAccount bankAccount);

    BankAccount covertExchangeBankAccount(Long id, String exchange);
}
