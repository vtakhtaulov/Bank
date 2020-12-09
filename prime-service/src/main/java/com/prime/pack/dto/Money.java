package com.prime.pack.dto;

import com.prime.pack.enums.Exchange;
import lombok.Data;

@Data
public class Money {

    private Double value;
    private Exchange exchange;
}
