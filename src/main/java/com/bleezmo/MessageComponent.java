package com.bleezmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 1/27/15
 * Time: 11:45 AM
 * #TODO
 */
@Component
public class MessageComponent {
    private final MessageService service;

    @Autowired
    public MessageComponent(MessageService service){
        this.service = service;
    }

    public String processMessage(String msg){
        return service.processMessage(msg);
    }
}
