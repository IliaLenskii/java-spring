package org.example.proxies;

import org.example.model.Comment;

public interface ICommentNotificationProxy {

    Boolean send(Comment comment);
}
