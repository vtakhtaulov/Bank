package com.prime.pack.service.impl;

import com.prime.pack.domain.BankAccount;
import com.prime.pack.feign.ConvertExchangeClient;
import com.prime.pack.repository.BankAccountRepository;
import com.prime.pack.repository.RefExchangeRepository;
import com.prime.pack.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

  private final BankAccountRepository bankAccountRepository;
  private final RefExchangeRepository refExchangeRepository;
  private final ConvertExchangeClient convertExchangeClient;

  @Override
  public List<BankAccount> getBankAccounts() {
    return bankAccountRepository.findAll();
  }

  @Override
  public List<BankAccount> getBankAccountsClient(Long idClient) {
    return bankAccountRepository.findByIdClient(idClient);
  }

  @Override
  public BankAccount getBankAccountClient(Long id) {
    return bankAccountRepository.findById(id).get();
  }

  @Override
  public BankAccount updateBankAccount(Long id, BankAccount bankAccount) {
    bankAccount.setId(id);
    return bankAccountRepository.save(bankAccount);
  }

  @Override
  public BankAccount addBankAccount(BankAccount bankAccount) {
    try {
      return bankAccountRepository.save(bankAccount);
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public BankAccount covertExchangeBankAccount(Long id, String moneyNextType) {

    BankAccount bankAccount = bankAccountRepository.findById(id).get();

    Double newMoneyValue =
        convertExchangeClient
            .convertExchange(
                bankAccount.getMoney(), bankAccount.getExchange().getNameExch(), moneyNextType)
            .getBody();

    bankAccount.setMoney(newMoneyValue);
    bankAccount.setExchange(refExchangeRepository.findByNameExch(moneyNextType).get(0));

    return bankAccountRepository.save(bankAccount);
  }
}
