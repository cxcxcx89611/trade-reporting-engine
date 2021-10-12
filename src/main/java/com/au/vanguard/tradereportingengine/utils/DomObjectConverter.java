package com.au.vanguard.tradereportingengine.utils;

import com.au.vanguard.tradereportingengine.config.mapping.DomToModelMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.lang.reflect.Field;

public class DomObjectConverter {

    public static <T> T populateObjectFields(T t, Document document) throws Exception {
        for (DomToModelMap domToModelMap : DomToModelMap.values()) {
            if (domToModelMap.getModelName().replace("com.au.vanguard.tradereportingengine.dto.", "").equalsIgnoreCase(t.getClass().getSimpleName())) {
                NodeList nodeList = document.getElementsByTagName(domToModelMap.getElementName());
                if (nodeList == null || nodeList.getLength() == 0) {
                    continue;
                }
                Element element = (Element) nodeList.item(0);
                String filedValue;
                if (domToModelMap.getDomAttribute() != null && !domToModelMap.getDomAttribute().isEmpty()) {
                    filedValue = element.getAttribute(domToModelMap.getDomAttribute());
                } else {
                    filedValue = element.getTextContent();
                }
                Field field = t.getClass().getDeclaredField(domToModelMap.getModelFieldName());
                if (field != null) {
                    field.setAccessible(true);
                    field.set(t, filedValue);
                }
            }
        }
        return t;
    }
}
