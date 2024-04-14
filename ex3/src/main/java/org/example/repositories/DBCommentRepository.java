package org.example.repositories;

import org.example.model.Comment;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DBCommentRepository implements ICommentRepository {

    @Override
    public Boolean store(Comment comment) {

        System.out.println("Storing comment:" + comment);
        return true;
    }
}
