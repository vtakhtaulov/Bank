package com.prime.pack.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "convert-exchange-service", path = "/convert")
public interface ConvertExchangeClient {

    @GetMapping
    ResponseEntity<Double> convertExchange(@RequestParam(name = "moneyValue") Double moneyValue,
                                      @RequestParam(name = "moneyPrevType") String moneyPrevType,
                                      @RequestParam(name = "moneyNextType") String moneyNextType);
}
