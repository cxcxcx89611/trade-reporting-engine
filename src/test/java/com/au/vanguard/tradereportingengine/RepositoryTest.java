package com.au.vanguard.tradereportingengine;

import com.au.vanguard.tradereportingengine.model.Trade;
import com.au.vanguard.tradereportingengine.repository.TradeCustomRepository;
import com.au.vanguard.tradereportingengine.repository.TradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeReportingEngineApplicationTests.class)
public class RepositoryTest {

    @Autowired
    TradeCustomRepository tradeCustomRepository;

    @Autowired
    TradeRepository tradeRepository;

    @Test
    public void getTradeByCriteriaTest(){
        Map<String,Object> valueObjectMap = new HashMap<>();
        valueObjectMap.put("sellerParty","EMU_BANK");
        valueObjectMap.put("currency","AUD");
        assertEquals(4,tradeCustomRepository.findUserByCustomCriteria(valueObjectMap).size() );
    }

    @Test
    public void getTradeTest(){
        assertEquals(8,tradeRepository.findAll().size() );
    }

}
