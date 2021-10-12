package com.au.vanguard.tradereportingengine.controller;

import com.au.vanguard.tradereportingengine.dto.ResponseDTO;
import com.au.vanguard.tradereportingengine.dto.TradeDto;
import com.au.vanguard.tradereportingengine.service.TradeService;
import com.au.vanguard.tradereportingengine.utils.ValidatorUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @GetMapping("/v1/trade")
    public ResponseDTO<List<TradeDto>> getTrade() {
        List<String> criteriaNameList = new ArrayList<>();
        criteriaNameList.add("TRADECRITERIA1");
        criteriaNameList.add("TRADECRITERIA2");
        List<TradeDto> tradeDtoList = tradeService.getTradeByCriteria(criteriaNameList);
        tradeDtoList = ValidatorUtil.filterAnagrams(tradeDtoList);
        ResponseDTO<List<TradeDto>> responseDTO = new ResponseDTO<List<TradeDto>>();
        responseDTO.setCode("200");
        responseDTO.setSuccess(true);
        responseDTO.setMessage("search query success, filter criteria is : " + String.join(",", criteriaNameList));
        responseDTO.setContent(tradeDtoList);
        return responseDTO;
    }
}
