package com.au.vanguard.tradereportingengine.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeDto {
   private String buyerPartyReference;
   private String sellerPartyReference;
   private String amount;
   private String currency;
}
