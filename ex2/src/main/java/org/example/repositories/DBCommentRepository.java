package org.example.repositories;

import org.example.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements ICommentRepository {

    @Override
    public Boolean store(Comment comment) {

        System.out.println("Storing comment:" + comment);
        return true;
    }
}
