package com.prime.pack.repository;

import com.prime.pack.domain.RefExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefExchangeRepository extends JpaRepository<RefExchange, Long> {
        List<RefExchange> findByNameExch(String name);
}
