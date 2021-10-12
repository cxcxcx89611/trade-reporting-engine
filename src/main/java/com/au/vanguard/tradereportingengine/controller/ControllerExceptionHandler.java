package com.au.vanguard.tradereportingengine.controller;


import com.au.vanguard.tradereportingengine.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDTO exceptionHandler(Exception e) {
        ResponseDTO responseDto = new ResponseDTO();
        responseDto.setSuccess(false);
        responseDto.setCode("500");
        LOG.error("Internal server error：{}", e.getMessage());
        responseDto.setMessage(e.getMessage());
        return responseDto;
    }
}
