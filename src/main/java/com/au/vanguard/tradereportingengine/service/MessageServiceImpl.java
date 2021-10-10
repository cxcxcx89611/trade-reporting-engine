package com.au.vanguard.tradereportingengine.service;

import com.au.vanguard.tradereportingengine.config.mapping.DomToModelMap;
import com.au.vanguard.tradereportingengine.dto.TradeDto;
import com.au.vanguard.tradereportingengine.model.Trade;
import com.au.vanguard.tradereportingengine.utils.DomObjectConverter;
import com.au.vanguard.tradereportingengine.utils.XMLParser;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public <T> void loadMessage(String messageString) throws Exception {
        Document document = XMLParser.parseXMLStringIntoDocument(messageString);
        //To verify what type message come through in terms of extendable.
        T t = DomObjectConverter.populateObjectFields(initiateModelByMessageType(document),document);
        if(t instanceof TradeDto) {
            System.out.println((TradeDto)t);
        }
    }

    public  <T> T initiateModelByMessageType(Document document) throws  Exception{
        for(DomToModelMap domToModelMap : DomToModelMap.values()) {
            NodeList nodeList = document.getElementsByTagName(domToModelMap.getMessageType());
            if(nodeList == null || nodeList.getLength() == 0) {
                return null;
            } else {
                    Class classDefinition = Class.forName(domToModelMap.getModelName());
                    T t = (T)classDefinition.newInstance();
                return t;
            }
        }
        return null;
    }
}
