package com.archit.springdatajpa.archit;

import com.archit.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBasedConfig {
    public static void main(String[] args) {
        //JAVA BASED SPRING CONFIGURATION
        //Earlier we were using xml file now we will have a java class file which will contain the required config for Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Alien obj =  context.getBean(Alien.class);
//       System.out.println(dt);
        //obj.coding() will give error here because coding requires Computer type member of Alien class to work
        //We have to give reference of Computer type object in AppConfig.java while defining Alien bean
        obj.coding();
    }
}
