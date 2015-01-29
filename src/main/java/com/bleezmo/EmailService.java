package com.bleezmo;

/**
 * Created with IntelliJ IDEA.
 * User: Josh Rogers
 * Date: 1/27/15
 * Time: 11:44 AM
 * #TODO
 */
public class EmailService implements MessageService{

    @Override
    public String processMessage(String msg) {
        System.out.println("msg: "+msg);
        return "msg: "+msg;
    }
}
