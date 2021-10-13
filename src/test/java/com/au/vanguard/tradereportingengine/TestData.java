package com.au.vanguard.tradereportingengine;

import com.au.vanguard.tradereportingengine.dto.TradeDto;

public enum TestData {
    GET_TRADE_BY_CRITERIA_CONTROLLER_TEST("getTradeByCriteria"," {\n" +
            "            \"buyerParty\": \"LEFT_BANK\",\n" +
            "            \"sellerParty\": \"EMU_BANK\",\n" +
            "            \"amount\": \"100.0\",\n" +
            "            \"currency\": \"AUD\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"buyerParty\": \"LEFT_BANK\",\n" +
            "            \"sellerParty\": \"EMU_BANK\",\n" +
            "            \"amount\": \"200.0\",\n" +
            "            \"currency\": \"AUD\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"buyerParty\": \"EMU_BANK\",\n" +
            "            \"sellerParty\": \"BISON_BANK\",\n" +
            "            \"amount\": \"500.0\",\n" +
            "            \"currency\": \"USD\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"buyerParty\": \"EMU_BANK\",\n" +
            "            \"sellerParty\": \"BISON_BANK\",\n" +
            "            \"amount\": \"600.0\",\n" +
            "            \"currency\": \"USD\"\n" +
            "        }"),
    GET_TRADE_BY_CRITERIA_SERVICE_TEST("getTradeByCriteria",new TradeDto("LEFT_BANK","EMU_BANK","100.0","AUD"));
    TestData(String testName, Object testData) {
        this.testName = testName;
        this.testData = testData;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Object getTestData() {
        return testData;
    }

    public void setTestData(Object testData) {
        this.testData = testData;
    }

    private String testName;
    private Object testData;
}
