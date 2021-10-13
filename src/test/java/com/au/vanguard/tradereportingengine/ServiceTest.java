package com.au.vanguard.tradereportingengine;

import com.au.vanguard.tradereportingengine.service.MessageService;
import com.au.vanguard.tradereportingengine.service.TradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeReportingEngineApplicationTests.class)
public class ServiceTest {

    @Autowired
    TradeService tradeService;

    @Autowired
    MessageService messageService;


    @Test
    public void getTradeByCriteria(){
        List<String> criteriaNameList = new ArrayList<>();
        criteriaNameList.add("TRADECRITERIA1");
        criteriaNameList.add("TRADECRITERIA2");
        assertEquals(6,tradeService.getTradeByCriteria(criteriaNameList).size() );
        assertTrue(tradeService.getTradeByCriteria(criteriaNameList).contains(TestData.GET_TRADE_BY_CRITERIA_SERVICE_TEST.getTestData()));
    }
}
