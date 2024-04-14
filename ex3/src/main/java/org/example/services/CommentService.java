package org.example.services;

import org.example.repositories.ICommentRepository;
import org.example.proxies.ICommentNotificationProxy;
import org.example.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("StereotypicalBean")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    //@Autowired // use it if constructor def
    private final ICommentRepository repository;

    //@Autowired // use it if constructor def
    private final ICommentNotificationProxy notificationProxy;

    @Autowired // not recommended
    private ApplicationContext context;

    public CommentService(ICommentRepository repository, ICommentNotificationProxy notificationProxy) {
        this.repository = repository;
        this.notificationProxy = notificationProxy;
    }

    public ICommentRepository getRepository() {
        return repository;
    }

    public ICommentNotificationProxy getNotificationProxy() {
        return notificationProxy;
    }

    public void publish(Comment comment) {
        repository.store(comment);
        notificationProxy.send(comment);
    }
}
