package com.archit.springdatajpa.archit;

public class Desktop implements Computer{
    public Desktop(){
        System.out.println("Desktop Object created");
    }
    @Override
    public void code() {
        System.out.println("Compiling using Desktop");
    }

    @Override
    public void playingGame() {
        System.out.println("Playing game in Desktop");
    }
}
