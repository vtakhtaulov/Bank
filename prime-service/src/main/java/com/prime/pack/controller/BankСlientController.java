package com.prime.pack.controller;

import com.prime.pack.domain.Client;
import com.prime.pack.service.BankClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/bank/client", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BankСlientController {

    private final BankClientService bankClientService;

    @GetMapping
    public ResponseEntity<?> getClients(){
        return ResponseEntity.ok(bankClientService.getClients());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(bankClientService.getClient(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateClientInfo(@PathVariable("id") Long id, @RequestBody Client client ){
        return ResponseEntity.ok(bankClientService.updateClientInfo(id, client));
    }

    @PostMapping
    public boolean addClient(@RequestBody Client client){
        return bankClientService.addClient(client);
    }
}
