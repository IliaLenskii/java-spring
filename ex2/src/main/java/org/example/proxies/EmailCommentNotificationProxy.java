package org.example.proxies;

import org.example.model.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("EmailNotificationProxy")
@Primary
public class EmailCommentNotificationProxy implements ICommentNotificationProxy {

    @Override
    public Boolean send(Comment comment) {

        System.out.println("Sending notification for comment: "+ comment);
        return true;
    }
}
