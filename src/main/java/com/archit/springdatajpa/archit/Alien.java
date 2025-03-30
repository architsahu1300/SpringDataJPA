package com.archit;


//We have 3 types of injection: Field injection, Constructor injection and Setter injection
//Field injection is when @Autowired done on a field. Example: private Computer com in below class
//Constructor injection is when @Autowired is done on a parameterized Constructor which requires a Computer object
//Setter injection is when above is done on a setter

//@Scope can be used on top of a class to specify the scope of that class bean
public class Alien{
    //We have a laptop object as member and is used in code()
    //Since the value is not set, by default lap is null hence we will get NullPointerException
    //To set value in lap using spring we need to give ref attribute in the spring.xml file's bean tag
    private Computer com;
    
    //Can use @Value annotation to inject a value to age parameter
    private int age;
    public Alien(){
        //System.out.println("Alien object constructor");
    }
    //Constructor Injection: We set values of age and lap using contructors but Spring does it for us
    //For this we need to define in spring.xml file that we will use constructors instead of setters to set values
//    public Alien(int age,Computer com){
//        System.out.println("Parameterized constructor of Alien class called");
//        this.age=age;
//        this.com=com;
//    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    //1. Here in setter we can pass Laptop/Desktop object and based on what is the object type at runtime, the respective playingGame() will run
    //2. In 2nd case we see that we have Computer Interface, and in spring.xml file the ref to set com is passed with laptop
    // object created in the same file.
    public void setCom(Computer com) {
        this.com = com;
    }

    public void coding(){
        System.out.println("Coding");
        com.code();
    }
}
