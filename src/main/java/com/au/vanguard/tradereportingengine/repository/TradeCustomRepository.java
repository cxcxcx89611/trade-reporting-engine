package com.au.vanguard.tradereportingengine.repository;

import com.au.vanguard.tradereportingengine.model.Trade;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class TradeCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Trade> findUserByCustomCriteria(Map<String,Object> columnValueMap ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Trade> query = cb.createQuery(Trade.class);
        Root<Trade> trade = query.from(Trade.class);
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String,Object> entry : columnValueMap.entrySet()) {
            Path<String> valuePath = trade.get(entry.getKey());
            Object valueObject = entry.getValue();
            predicates.add(cb.equal(valuePath, valueObject));
        }
        query.select(trade)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(query)
                .getResultList();
    }
}
