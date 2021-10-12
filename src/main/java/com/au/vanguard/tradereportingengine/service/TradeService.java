package com.au.vanguard.tradereportingengine.service;

import com.au.vanguard.tradereportingengine.model.Trade;

import java.util.List;

public interface TradeService {
    public List<Trade> getTradeByCriteria(List<String> trateCriteriaName) throws Exception;
}
