package org.example.proxies;

import org.example.model.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("EmailNotificationProxy")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Primary
public class EmailCommentNotificationProxy implements ICommentNotificationProxy {

    @Override
    public Boolean send(Comment comment) {

        System.out.println("Sending notification for comment: "+ comment);
        return true;
    }
}
