package org.example.services;

import org.example.proxies.IToLog;
import org.example.repositories.ICommentRepository;
import org.example.proxies.ICommentNotificationProxy;
import org.example.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.stereotype.Service;

import java.util.logging.Logger; // JDK

@Service("StereotypicalBean")
public class CommentService {

    private final ICommentRepository repository; // del

    private final ICommentNotificationProxy notificationProxy; // del

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired // not recommended
    private ApplicationContext context;

    public CommentService(ICommentRepository repository, ICommentNotificationProxy notificationProxy) {
        this.repository = repository;
        this.notificationProxy = notificationProxy;
    }

    public Number publish(Comment comment) {

        //repository.store(comment);
        //notificationProxy.send(comment);

        logger.info( comment.toString() );

        return 0;
    }

    @IToLog
    public void delete(Comment comment) {

        logger.info( "deleting comment" );
    }

    public void edit(Comment comment) {

        logger.info( "edit comment" );
    }
}
