package org.example.proxies;

import org.example.model.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("SMSNotificationProxy")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SMSCommentNotificationProxy implements ICommentNotificationProxy {

    @Override
    public Boolean send(Comment comment) {

        System.out.println("SMS notification for comment: "+ comment);
        return true;
    }
}
