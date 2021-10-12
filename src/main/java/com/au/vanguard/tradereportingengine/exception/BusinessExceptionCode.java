package com.au.vanguard.tradereportingengine.exception;

public enum BusinessExceptionCode {
    TOKEN_EXPIRED("TOKEN EXPIRED"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}