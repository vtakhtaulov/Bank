package com.prime.pack.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "bank", name = "ref_exchange")
public class RefExchange extends AbstractDomain {

    @Column(name = "name")
    private String nameExch;
}
