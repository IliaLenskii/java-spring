package org.example.repositories;

import org.example.model.Comment;

public interface ICommentRepository {

    Boolean store(Comment comment);
}
