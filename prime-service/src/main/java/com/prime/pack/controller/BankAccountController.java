package com.prime.pack.controller;

import com.prime.pack.domain.BankAccount;
import com.prime.pack.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/bank/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping
    public ResponseEntity<?> getBankAccounts(){
        return ResponseEntity.ok(bankAccountService.getBankAccounts());
    }

    @GetMapping(path = "/getAccountsClient")
    public ResponseEntity<?> getBankAccountsClient(@RequestParam(name = "idClient") Long idClient){
        return ResponseEntity.ok(bankAccountService.getBankAccountsClient(idClient));
    }

    @GetMapping(path = "/getAccount")
    public ResponseEntity<?> getBankAccountClient(@RequestParam(name = "id") Long id){
        return ResponseEntity.ok(bankAccountService.getBankAccountClient(id));
    }

    @PostMapping
    public ResponseEntity<?> addBankAccount(@RequestBody BankAccount bankAccount){
        return ResponseEntity.ok(bankAccountService.addBankAccount(bankAccount));
    }
    @PutMapping(name = "/{id}")
    public ResponseEntity<?> updateBunkAccount(@PathVariable Long id, @RequestBody BankAccount bankAccount){
        return ResponseEntity.ok(bankAccountService.updateBankAccount(id, bankAccount));
    }

    @PutMapping(path = "/convert/{id}")
    public ResponseEntity<?> covertExchangeBankAccount(@PathVariable Long id, @RequestBody String val){
        return ResponseEntity.ok(bankAccountService.covertExchangeBankAccount(id, val));
    }

}
