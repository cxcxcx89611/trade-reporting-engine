package com.au.vanguard.tradereportingengine.repository;

import com.au.vanguard.tradereportingengine.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findAll();
}
