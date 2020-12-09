package com.convert.pack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Exchange {
    RUB(1),
    USD(2),
    EUR(3);

    private int value;
}
