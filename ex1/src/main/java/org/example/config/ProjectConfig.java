package org.example.config;

import org.example.beans.Parrot;
import org.example.beans.Pirate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.beans")
public class ProjectConfig {

    @Bean("parrot")
    @Primary
    Parrot parrot() {
        return new Parrot("Parr1");
    }

    @Bean("parrot2")
    Parrot parrot2() {
        return new Parrot("Parr2");
    }

    @Bean("BlueBeard")
    Pirate pirate1( @Qualifier("parrot2") Parrot parrot ) {

        // @Qualifier - injection a bean from context
        // I can use it in constructor, like this:
        // public Pirate( @Qualifier("parrot2") Parrot parrot )

        parrot.setName("BlueBeard's parrot");

        Pirate p = new Pirate("BlueBeard");
               p.setParrot(parrot);

        return p;
    }

}
