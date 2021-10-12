package com.au.vanguard.tradereportingengine.utils;

import com.au.vanguard.tradereportingengine.dto.TradeDto;
import com.au.vanguard.tradereportingengine.exception.ValidatorException;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidatorUtil {

    /**
     * （null or ""）
     */
    public static void require(Object str, String fieldName) {
        if (StringUtils.isEmpty(str)) {
            throw new ValidatorException(fieldName + "can not be null");
        }
    }

    /**
     *  filter anagrams by given trade dto list
     */
    public static List<TradeDto> filterAnagrams(List<TradeDto> tradeDtoList) {
        List<TradeDto> filteredTradeDtoList = new ArrayList<>();
        tradeDtoList.forEach(a -> {
            char[] a1 = a.getBuyerParty().toCharArray();
            char[] a2 = a.getSellerParty().toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);
            if (!Arrays.equals(a1, a2)) {
                filteredTradeDtoList.add(a);
            }
        });
        return filteredTradeDtoList;
    }

    /**
     * length check
     */
    public static void length(String str, String fieldName, int min, int max) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        int length = 0;
        if (!StringUtils.isEmpty(str)) {
            length = str.length();
        }
        if (length < min || length > max) {
            throw new ValidatorException(fieldName + "length" + min + "~" + max + "digit");
        }
    }
}