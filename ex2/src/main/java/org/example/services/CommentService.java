package org.example.services;

import org.example.repositories.ICommentRepository;
import org.example.proxies.ICommentNotificationProxy;
import org.example.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final ICommentRepository repository;
    private final ICommentNotificationProxy notificationProxy;

    public CommentService(ICommentRepository repository, ICommentNotificationProxy notificationProxy) {
        this.repository = repository;
        this.notificationProxy = notificationProxy;
    }

    public void publish(Comment comment) {
        repository.store(comment);
        notificationProxy.send(comment);
    }
}
