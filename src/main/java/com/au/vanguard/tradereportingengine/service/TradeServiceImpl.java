package com.au.vanguard.tradereportingengine.service;

import com.au.vanguard.tradereportingengine.config.criteria.QueryFilterCriteria;
import com.au.vanguard.tradereportingengine.dao.TradeDao;
import com.au.vanguard.tradereportingengine.dto.TradeDto;
import com.au.vanguard.tradereportingengine.model.Trade;
import com.au.vanguard.tradereportingengine.utils.CopyBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeDao tradeDao;

    @Override
    public List<TradeDto> getTradeByCriteria(List<String> tradeCriteriaName){
        Map<String, Object> columnValueMap = new HashMap<String, Object>();
        List<TradeDto> tradeDtoList = new ArrayList<TradeDto>();
        tradeCriteriaName.forEach(a -> {
            for (QueryFilterCriteria queryFilterCriteria : QueryFilterCriteria.values()) {
                if (a.equalsIgnoreCase(queryFilterCriteria.getCriteriaName())) {
                    columnValueMap.put(queryFilterCriteria.getAttrFieldName(), queryFilterCriteria.getValue());
                }
            }
            tradeDtoList.addAll(CopyBeanUtils.copyList(tradeDao.getTradeByCriteria(columnValueMap), TradeDto.class));
        });
        return tradeDtoList;
    }
}
