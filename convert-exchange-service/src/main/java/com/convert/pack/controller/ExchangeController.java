package com.convert.pack.controller;

import com.convert.pack.repository.RefExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/convert")
public class ExchangeController {

  private final RefExchangeRepository refExchangeRepository;

  @GetMapping
  public ResponseEntity<?> convertExchange(
      @RequestParam(name = "moneyValue") Double moneyVal,
      @RequestParam(name = "moneyPrevType") String moneyPrevType,
      @RequestParam(name = "moneyNextType") String moneyNextType) {

    return ResponseEntity.ok(convert(moneyVal, moneyPrevType, moneyNextType));
  }

  private Double convert(Double moneyVal, String moneyPrevType, String moneyNextType){
    Double resultValue = 0d;

    if (moneyNextType.equals("RUB")) {
      if (moneyPrevType.equals("RUB")) resultValue = moneyVal * 1;
      if (moneyPrevType.equals("EUR"))
        resultValue =
                moneyVal * refExchangeRepository.findByName("EUR").getCoursInRub();
      if (moneyPrevType.equals("USD"))
        resultValue =
                moneyVal * refExchangeRepository.findByName("USD").getCoursInRub();
    } else if (moneyNextType.equals("EUR")) {
      if (moneyPrevType.equals("EUR")) resultValue = moneyVal * 1;
      if (moneyPrevType.equals("RUB"))
        resultValue =
                moneyVal / refExchangeRepository.findByName("EUR").getCoursInRub();
      if (moneyPrevType.equals("USD"))
        resultValue =
                (moneyVal * refExchangeRepository.findByName("USD").getCoursInRub())
                        / refExchangeRepository.findByName("EUR").getCoursInRub();
    } else if (moneyNextType.equals("USD")) {
      if (moneyPrevType.equals("USD")) resultValue = moneyVal * 1;
      if (moneyPrevType.equals("RUB"))
        resultValue =
                moneyVal / refExchangeRepository.findByName("USD").getCoursInRub();
      if (moneyPrevType.equals("EUR"))
        resultValue =
                (moneyVal * refExchangeRepository.findByName("EUR").getCoursInRub())
                        / refExchangeRepository.findByName("USD").getCoursInRub();
    }

    return resultValue;
  }
}
