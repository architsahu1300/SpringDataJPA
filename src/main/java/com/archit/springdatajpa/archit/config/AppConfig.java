package com.archit.springdatajpa.archit.config;

import com.archit.Alien;
import com.archit.Computer;
import com.archit.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//COMPONENT
//If we want to skip all the below steps we can directly tell Spring that it needs to manage the objects of the specified classes
//@Component
//public class Alien{......}
//@Component
//public class Desktop
//@Component
//public class Laptop

//But writing above also won't help because in the main method we have specified that we will use AppConfig.java class for configuration
//To tell Spring that it needs to check other classes for @Component annotation so it can use them to manage objects,
//we need another annotation in the AppConfig class, i.e.,  @ComponentScan(packageName: "com.archit")
//Now spring will look for classes with @Component inside com.archit package and manage them if present

//But we still need to connect the Computer type object required in Alien class to run the coding method
//For this we need to specify in Alien class that this member "com" is supposed to be autowired
//@Autowired
//Computer com
//By writing this, Spring will go back and check if container has a Computer type object present and use it

//Above case again will create confusion if 2 beans of type Computer are present, to solve this:
//We can use @Qualifier("desktop") above the com member in Alien class and the name will be class name in small case
//We can also use @Primary on top of the class to tell spring which one to prioritise
//If Qualifier and Primary are used on 2 separate classes, Qualifier class is preferred.



@Configuration
public class AppConfig {
    //We are telling Spring that this desktop is the bean which needs to be returned
    //Spring calls this method, creates and manages the bean
    @Bean
//    @Scope("prototype")
    public Desktop desktop(){
        return new Desktop();
    }
    //BEAN NAME
    //In above config, the method name dektop() is the bean name and can be called by this name in getBean()
    //For other names we can use attributes in the @Bean annotation like @Bean({"computer1","desktop1"})

    //BEAN SCOPE
    //@Scope annotation like @Scope("prototype")

    //We are now defining bean def for Alien and it requires a Computer type reference since it has a member of type Computer.
    @Bean
    public Alien alien(Computer com) /*@Qualifier("desktop")*/ {
        //Writing the code to give Computer reference here
        Alien obj=new Alien();
        obj.setAge(24);
        //Giving the desktop() bean created above to this method so that
        // while returning the bean it contains Computer type reference needed to run coding()
//        obj.setCom(desktop());
        //AUTOWIRING
        //Above code is tightly coupled, what if we don't always want Desktop sometimes want a laptop
        //To solve this we can make the alien bean dependent on Computer type object.
        //So once we say alien(Computer com), spring will look for an object/bean of type Computer and use that bean
        //In this case since desktop object is already present in the container as defined above, spring will use that for AUTOWIRING
        //Earlier we had to write alien(@autowired Computer com) now without @autowired it works fine
        obj.setCom(com);
        return obj;
    }

    //PRIMARY & QUALIFIER
    //If the config has 2 beans of type Computer(Laptop & Desktop) there are 2 ways to solve this
    //If we use @Qualifier("desktop") over the Alien bean definition, it will prefer the dektop bean
    //If we specify @Primary over Laptop bean definition, in case of confusion it will be given priority
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
