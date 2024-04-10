package org.example;

import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.model.Comment;
import org.example.services.CommentService;

public class Main {

    public static void main(String[] args) {

        // use var
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        
        CommentService commtServ = context.getBean(CommentService.class);

        commtServ.publish( new Comment("Harrison Ford", "It was a great adventure") );
    }
}
