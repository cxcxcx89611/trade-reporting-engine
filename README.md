# Trade-Reporting-Engine
Author: Izzy Chen      
Date: 12th Oct 2021

##  how to run

git clone https://github.com/cxcxcx89611/trade-reporting-engine.git

mvn spring-boot:run  or  use intellij springboot runner 

To check if message get loaded,  use database console:http://localhost:8080/trade-report-engine/h2/

driver class: org.h2.Driver
jdbc url: jdbc:h2:mem:dbtest
username:sa
password:sa

when want to query the data filtered by the criteria, use postman do the get request through below endpoint :
http://localhost:8080/trade-report-engine/v1/trade

##  introduction to design and implementation

trade reporting engine are implemented through spring boot microservices,  its main functionalities involve two stages :1. message consumer to load event messages 2. rest service provider to respond user request.

com.au.vanguard.tradereportingengine.runner.MessageConsumer   plays the role as the message consumer to get message loaded into H2 database. When application start, all event messages under folder: \src\main\resources\event will be picked and loaded.

**To extend the event types,**  please ensure all other messages move into folder :\src\main\resources\event  also need to add new entry in the mapping config file :  src/main/java/com/au/vanguard/tradereportingengine/config/mapping/DomToModelMap.java
Dom element to entity class mapping can be defined in this class. Message consumer will read this file to populate all fields of model class object, then load them into DB. 

**To extend the query filter criteria**, please refer to the criteria decision file: 
src/main/java/com/au/vanguard/tradereportingengine/config/criteria/QueryFilterCriteria.java
each query criteria should have unique criteria name as following shows:

    BUYER_PARTY_TRADECRITERIA1("sellerParty","EMU_BANK","Trade","***TRADECRITERIA1***"),  
    PREMIUM_CURRENCY_TRADECRITERIA1("currency","AUD","Trade","***TRADECRITERIA1***"),

If new criteria need to be added on just inject the criteria name as part of the controler as 

    src/main/java/com/au/vanguard/tradereportingengine/controller/TradeController.java:
    List<String> criteriaNameList = new ArrayList<>();  
    criteriaNameList.add("TRADECRITERIA1");  
    criteriaNameList.add("TRADECRITERIA2");  
    List<TradeDto> tradeDtoList = tradeService.getTradeByCriteria(criteriaNameList); 

TradeController plays the role as restful services endpoint. When user hit the  endpoint through Get method: http://localhost:8080/trade-report-engine/v1/trade, the application will return the data filtered by criteria:

    { "success": true, "code": "200", "message": "search query success, filter criteria is : TRADECRITERIA1,TRADECRITERIA2", "content": [ { "buyerParty": "LEFT_BANK", "sellerParty": "EMU_BANK", "amount": "100.0", "currency": "AUD" }, { "buyerParty": "LEFT_BANK", "sellerParty": "EMU_BANK", "amount": "200.0", "currency": "AUD" }, { "buyerParty": "EMU_BANK", "sellerParty": "BISON_BANK", "amount": "500.0", "currency": "USD" }, { "buyerParty": "EMU_BANK", "sellerParty": "BISON_BANK", "amount": "600.0", "currency": "USD" } ] }


## Test cases

please check src/test folder.
In this project,  unit tests have been implemented to cover each app layer:
1. Application Test
2. Controller Test
3. Service Test
4. Dao Test
5. Repository Test

## Improvement or thoughts for the future
1. To facilitate this application extendibility and usability in the future, more restful endpoints can be made along with criteria as part of request param.
for example,  http://localhost:8080/trade-report-engine/v1/trade?criteria=XXXX
Application will filter and return the data by given criteria name in the param list.
2.  To ensure no message loss at any time(data integrity),  need to separate message consumer and restful service, build up two applications, one is up and run to consume and load message all the time. Another is a purely restful service spring boot application.
So to ensure 0 downtime for consumer app, can wrap it up as docker container through k8s. Any consumer container become red and get offline will trigger K8s create new container take it over. The rest spring boot application can be deployed behind API gateway to facilitate easily manage and improve security.
