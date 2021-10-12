package com.au.vanguard.tradereportingengine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trade implements Serializable {
    @Id
    @Column(name="trade_id")
    @GeneratedValue
    private Long tradeId;
    @Column(name="buyer_party")
    private String buyerParty;
    @Column(name="seller_party")
    private String sellerParty;
    @Column(name="premium_amount")
    private String amount;
    @Column(name="premium_currency")
    private String currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return Objects.equals(tradeId, trade.tradeId) &&
                Objects.equals(buyerParty, trade.buyerParty) &&
                Objects.equals(sellerParty, trade.sellerParty) &&
                Objects.equals(amount, trade.amount) &&
                Objects.equals(currency, trade.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId, buyerParty, sellerParty, amount, currency);
    }
}
