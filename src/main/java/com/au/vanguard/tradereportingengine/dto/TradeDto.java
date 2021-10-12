package com.au.vanguard.tradereportingengine.dto;

public class TradeDto {
   private String buyerParty;
   private String sellerParty;
   private String amount;
   private String currency;

   public TradeDto() {
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
