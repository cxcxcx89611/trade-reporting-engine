package com.au.vanguard.tradereportingengine;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import static org.assertj.core.api.Assertions.assertThat;

/*
* application test:
* 1.start localhost application
* 2.execute all below test cases
*
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradeReportingEngineApplicationTests.class)
public class ApplicationTest {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080"+"/trade-report-engine/v1/trade";

    public static HttpEntity createHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
        return entity;
    }

    @Test
    public void getTradeReuqestTest(){
        assertThat(restTemplate.getForEntity(url,String.class).getStatusCode().equals(200));
        assertThat(restTemplate.getForEntity(url,String.class).toString().contains("buyerParty"));
        assertThat(restTemplate.getForEntity(url,String.class).toString().contains(" {\n" +
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
                "        }"));
    }
}
