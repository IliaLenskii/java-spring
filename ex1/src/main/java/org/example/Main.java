package org.example;

import org.example.beans.Boat;
import org.example.beans.Parrot;
import org.example.beans.Pirate;
import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        // use var
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p1 = context.getBean("parrot", Parrot.class);

        p1.setName("Jack-ok");

        System.out.println( p1.getName() );

        Pirate pir = context.getBean(Pirate.class);

        pir.setName("BlackBeard");

        System.out.println( pir.getName() +" and "+ pir.getParrot() );

        context.registerBean(Boat.class);

        Boat b1 = context.getBean(Boat.class);

        b1.setName("Boat1");

        System.out.println( b1.getName() );

        // ---------

        Pirate PBlueBeard = context.getBean("BlueBeard", Pirate.class);

        System.out.println( PBlueBeard.getName() +" _ "+ PBlueBeard.getParrot().getName() );
    }
}
