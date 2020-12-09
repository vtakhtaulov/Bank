package com.convert.pack.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(schema = "exch", name = "ref_exchange")
public class RefExchange extends AbstractDomain {

  @Column(name = "name")
  private String name;

  @Column(name = "cours_in_rub")
  private Double coursInRub;
}
