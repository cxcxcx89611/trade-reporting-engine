package com.au.vanguard.tradereportingengine.config.criteria;

public enum QueryFilterCriteria {

    BUYER_PARTY_TRADECRITERIA1("sellerParty","EMU_BANK","Trade","TRADECRITERIA1"),
    PREMIUM_CURRENCY_TRADECRITERIA1("currency","AUD","Trade","TRADECRITERIA1"),
    BUYER_PARTY_TRADECRITERIA2("sellerParty","BISON_BANK","Trade","TRADECRITERIA2"),
    PREMIUM_CURRENCY_TRADECRITERIA2("currency","USD","Trade","TRADECRITERIA2");

    private String attrFieldName;

    private Object value;

    private String className;

    private String criteriaName;

    QueryFilterCriteria() {
    }

    QueryFilterCriteria(String attrFieldName, Object value, String className, String criteriaName) {
        this.attrFieldName = attrFieldName;
        this.value = value;
        this.className = className;
        this.criteriaName = criteriaName;
    }

    public String getAttrFieldName() {
        return attrFieldName;
    }

    public void setAttrFieldName(String attrFieldName) {
        this.attrFieldName = attrFieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }
}
