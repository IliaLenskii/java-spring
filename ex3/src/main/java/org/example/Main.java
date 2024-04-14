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

        CommentService cl1 = context.getBean("CommentService", CommentService.class);
        CommentService cl2 = context.getBean("CommentService", CommentService.class);

        System.out.println(cl1 == cl2);

        CommentService cl3 = context.getBean("StereotypicalBean", CommentService.class);
        CommentService cl4 = context.getBean("StereotypicalBean", CommentService.class);

        System.out.println(cl3 +", rep: "+ cl3.getRepository() +", notif: "+ cl3.getNotificationProxy());
        System.out.println(cl4 +", rep: "+ cl4.getRepository() +", notif: "+ cl4.getNotificationProxy());
        
        //CommentService commtServ = context.getBean(CommentService.class);

        //commtServ.publish( new Comment("Harrison Ford", "It was a great adventure") );
    }
}
