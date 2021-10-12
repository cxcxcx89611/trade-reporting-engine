package com.au.vanguard.tradereportingengine.config.criteria;

public enum QueryFilterCriteria {

    BUYER_PARTY_TRADECRITERIA1("BUYER_PARTY","EMU_BANK","TRADE","TRADECRITERIA1"),
    PREMIUM_CURRENCY_TRADECRITERIA1("PREMIUM_CURRENCY","AUD","TRADE","TRADECRITERIA1"),
    BUYER_PARTY_TRADECRITERIA2("BUYER_PARTY","BISON_BANK","TRADE","TRADECRITERIA2"),
    PREMIUM_CURRENCY_TRADECRITERIA2("PREMIUM_CURRENCY","USD","TRADE","TRADECRITERIA2");

    private String columnName;

    private Object value;

    private String tableName;

    private String criteriaName;

    QueryFilterCriteria() {
    }

    QueryFilterCriteria(String columnName, Object value, String tableName, String criteriaName) {
        this.columnName = columnName;
        this.value = value;
        this.tableName = tableName;
        this.criteriaName = criteriaName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }
}
