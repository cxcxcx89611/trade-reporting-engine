package com.au.vanguard.tradereportingengine.service;

import com.au.vanguard.tradereportingengine.dto.TradeDto;
import com.au.vanguard.tradereportingengine.model.Trade;

import java.util.List;

public interface TradeService {
    public List<TradeDto> getTradeByCriteria(List<String> trateCriteriaName);
}
