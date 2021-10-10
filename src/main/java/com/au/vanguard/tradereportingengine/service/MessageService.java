package com.au.vanguard.tradereportingengine.service;

public interface MessageService {
    public <T> void loadMessage(String messageString) throws Exception;
}
