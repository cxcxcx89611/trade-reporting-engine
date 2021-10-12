package com.au.vanguard.tradereportingengine.service;

import com.au.vanguard.tradereportingengine.config.criteria.QueryFilterCriteria;
import com.au.vanguard.tradereportingengine.dao.TradeDao;
import com.au.vanguard.tradereportingengine.model.Trade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeDao tradeDao;

    @Override
    public List<Trade> getTradeByCriteria(List<String> tradeCriteriaName) throws Exception {
        Map<String, Object> columnValueMap = new HashMap<String,Object>();
        for(QueryFilterCriteria queryFilterCriteria: QueryFilterCriteria.values()) {
            tradeCriteriaName.forEach(a->{
                if(a.equalsIgnoreCase(queryFilterCriteria.getCriteriaName())){
                    columnValueMap.put(queryFilterCriteria.getColumnName(),queryFilterCriteria.getValue());
                }
            });
        }
        return tradeDao.getTradeByCriteria(columnValueMap);
    }
}
