package com.archit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //To let Spring manage alien objects we need ApplicationContext (3 ways to configure - xml,java,annotations)
        //To get ApplicationContext add "Spring context" dependency in pom.xml
        //Only adding context won't work because we need to tell Spring which class object it should manage
        //1st way is xml based where we create resources->spring.xml and define beans inside it with the class spring should manage
        //ClassPathXmlApplicationContext will look in resources folder for the xml file
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");

        //Spring created object in above line of code by reading the spring.xml file
        //Creates objects for all the beans written there. Even if two different ids created for same class, 2 objects are created
        //If we try to get objects of same id we will get the same object as one object created for every id.
//        Alien obj1= (Alien) context.getBean("alien1");
//        Alien obj2= (Alien) context.getBean("alien2");
//        Alien obj3= (Alien) context.getBean("alien1");
//        System.out.println(obj1);
//        System.out.println(obj2);
//        System.out.println(obj3);

        //Setter Injection: we insert/set values for variables using spring bean definition in spring.xml
        Alien obj=(Alien) context.getBean("alien2");
        System.out.println("Age of alien coding is: "+obj.getAge());
        //Since we gave reference of laptop object while setting com in Alien class, the below code will call coding()
        //of alien class which has com.code() calling laptop class due to runtime object being laptop
        obj.coding();
        Laptop lp=(Laptop)context.getBean("com");
        System.out.println(lp);
        Laptop lp2=(Laptop)context.getBean("com");
        System.out.println(lp2);

        //Lets say Alien class has a Laptop object as member therefore is dependent on laptop class.
        //Check alien class for further comments

        //getBean by TYPE
        //We can get a bean by specifying the class type ad we won't need type casting anymore.
        //Only downside is that in case of interfaces, if Spring has 2 beans of 2 classes which implement same interface, we'll get error
        Desktop obj2=context.getBean("com2",Desktop.class);
        obj2.code();
    }
}
