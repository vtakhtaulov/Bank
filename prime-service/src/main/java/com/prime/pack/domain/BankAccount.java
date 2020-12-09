package com.prime.pack.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(schema = "bank", name = "bank_account")
@Entity
public class BankAccount extends AbstractDomain {

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "number")
    private String number;

    @Column(name = "money")
    private Double money;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_exchange", referencedColumnName = "id")
    private RefExchange exchange;
}
