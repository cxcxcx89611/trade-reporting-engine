package com.au.vanguard.tradereportingengine.dao;

import com.au.vanguard.tradereportingengine.model.Trade;
import com.au.vanguard.tradereportingengine.repository.TradeCustomRepository;
import com.au.vanguard.tradereportingengine.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TradeDao {

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    TradeCustomRepository tradeCustomRepository;

    public List<Trade> getAllTrade() throws Exception {
        return tradeRepository.findAll();
    }

    public void SaveTrade(Trade trade) throws Exception {
        tradeRepository.save(trade);
    }

    public List<Trade> getTradeByCriteria(Map<String,Object> valueObjectMap){
        return tradeCustomRepository.findUserByCustomCriteria(valueObjectMap);
    }
}
