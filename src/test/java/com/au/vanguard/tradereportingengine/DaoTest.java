package com.au.vanguard.tradereportingengine;

import com.au.vanguard.tradereportingengine.dao.TradeDao;
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
public class DaoTest {

    @Autowired
    TradeDao tradeDao;

    @Test
    public void getTradeByCriteriaTest(){
        Map<String,Object> valueObjectMap = new HashMap<>();
        valueObjectMap.put("sellerParty","EMU_BANK");
        valueObjectMap.put("currency","AUD");
        assertEquals(4,tradeDao.getTradeByCriteria(valueObjectMap).size() );
    }

    @Test
    public void getTradeAllTest() throws Exception{
        assertEquals(8,tradeDao.getAllTrade().size() );
    }
}
