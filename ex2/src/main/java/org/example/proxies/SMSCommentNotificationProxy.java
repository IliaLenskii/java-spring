package org.example.proxies;

import org.example.model.Comment;
import org.springframework.stereotype.Component;

@Component("SMSNotificationProxy")
public class SMSCommentNotificationProxy implements ICommentNotificationProxy {

    @Override
    public Boolean send(Comment comment) {

        System.out.println("SMS notification for comment: "+ comment);
        return true;
    }
}
