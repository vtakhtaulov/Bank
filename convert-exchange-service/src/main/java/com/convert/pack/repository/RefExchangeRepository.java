package com.convert.pack.repository;

import com.convert.pack.domain.RefExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefExchangeRepository extends JpaRepository<RefExchange, Long> {
    RefExchange findByName(String name);
}
