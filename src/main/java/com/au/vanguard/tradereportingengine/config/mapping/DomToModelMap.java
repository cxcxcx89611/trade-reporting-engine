package com.au.vanguard.tradereportingengine.config.mapping;

public enum DomToModelMap {

    BUYER_PARTY("requestConfirmation","com.au.vanguard.tradereportingengine.dto.TradeDto","buyerPartyReference","buyerParty","href"),
    SELLER_PARTY("requestConfirmation","com.au.vanguard.tradereportingengine.dto.TradeDto","sellerPartyReference","sellerParty","href"),
    PREMIUM_AMOUNT("requestConfirmation","com.au.vanguard.tradereportingengine.dto.TradeDto","amount","amount",""),
    PREMIUM_CURRENCY("requestConfirmation","com.au.vanguard.tradereportingengine.dto.TradeDto","currency","currency","");

    private String messageType;

    private String modelName;

    private String elementName;

    private String modelFieldName;

    private String domAttribute;

    DomToModelMap() {
    }

    DomToModelMap(String messageType, String modelName, String elementName, String modelFieldName, String domAttribute) {
        this.messageType = messageType;
        this.modelName = modelName;
        this.elementName = elementName;
        this.modelFieldName = modelFieldName;
        this.domAttribute = domAttribute;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getModelFieldName() {
        return modelFieldName;
    }

    public void setModelFieldName(String modelFieldName) {
        this.modelFieldName = modelFieldName;
    }

    public String getDomAttribute() {
        return domAttribute;
    }

    public void setDomAttribute(String domAttribute) {
        this.domAttribute = domAttribute;
    }
}
