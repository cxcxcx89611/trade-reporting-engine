package com.au.vanguard.tradereportingengine.dto;

import java.util.Objects;

public class TradeDto {
   private String buyerParty;
   private String sellerParty;
   private String amount;
   private String currency;

   public TradeDto() {
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TradeDto tradeDto = (TradeDto) o;
      return Objects.equals(buyerParty, tradeDto.buyerParty) &&
              Objects.equals(sellerParty, tradeDto.sellerParty) &&
              Objects.equals(amount, tradeDto.amount) &&
              Objects.equals(currency, tradeDto.currency);
   }

   @Override
   public int hashCode() {
      return Objects.hash(buyerParty, sellerParty, amount, currency);
   }

   public TradeDto(String buyerParty, String sellerParty, String amount, String currency) {
      this.buyerParty = buyerParty;
      this.sellerParty = sellerParty;
      this.amount = amount;
      this.currency = currency;
   }

   public String getBuyerParty() {
      return buyerParty;
   }

   public void setBuyerParty(String buyerParty) {
      this.buyerParty = buyerParty;
   }

   public String getSellerParty() {
      return sellerParty;
   }

   public void setSellerParty(String sellerParty) {
      this.sellerParty = sellerParty;
   }

   public String getAmount() {
      return amount;
   }

   public void setAmount(String amount) {
      this.amount = amount;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }
}
