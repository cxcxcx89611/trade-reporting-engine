package com.au.vanguard.tradereportingengine.runner;

import com.au.vanguard.tradereportingengine.service.MessageService;
import com.au.vanguard.tradereportingengine.utils.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageConsumer implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    @Value("${vanguard.trade.message.path}")
    String eventMessagePath;

    @Autowired
    MessageService messageService;

    @Override
    public void run(String... args) {
        try {
            List<String> fileStringList = FileReader.readFile(eventMessagePath);
            fileStringList.forEach(a -> {
                try {
                    messageService.loadMessage(a);
                } catch (Exception ex) {
                    LOG.error("message consumer load message run time exception: " + ex.getStackTrace());
                }
            });
        } catch (Exception ex) {
            LOG.error("message consumer I/O run time exception: " + ex.getStackTrace());
        }
    }
}
