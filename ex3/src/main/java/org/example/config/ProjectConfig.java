package org.example.config;

import org.example.proxies.ICommentNotificationProxy;
import org.example.repositories.ICommentRepository;
import org.example.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"org.example.services", "org.example.proxies", "org.example.repositories"})
public class ProjectConfig {

    @Bean("CommentService")
    //@Scope(BeanDefinition.SCOPE_PROTOTYPE) // always return new instance
    public CommentService commentService(
            @Qualifier("DBCommentRepository") ICommentRepository repository,
            @Qualifier("EmailNotificationProxy") ICommentNotificationProxy notificationProxy
    ) {

        return new CommentService(repository, notificationProxy);
    }
}
