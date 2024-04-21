package org.example.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"org.example.services", "org.example.proxies", "org.example.repositories"})
@EnableAspectJAutoProxy
public class ProjectConfig {

}
