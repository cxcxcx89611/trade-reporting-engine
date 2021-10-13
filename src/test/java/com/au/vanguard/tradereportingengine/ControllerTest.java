package com.au.vanguard.tradereportingengine;

import com.au.vanguard.tradereportingengine.controller.TradeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeReportingEngineApplicationTests.class)
public class ControllerTest {
    @Autowired
    TradeController tradeController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getTradeByCriteriaTest() throws Exception {
        mvc.perform(get("/v1/trade"))
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase(String.valueOf(TestData.GET_TRADE_BY_CRITERIA_CONTROLLER_TEST.getTestData()));
    }

}
