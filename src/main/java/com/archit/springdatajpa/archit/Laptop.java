package com.archit.springdatajpa.archit;

import com.archit.Computer;

public class Laptop implements Computer {
    String processor;
    public Laptop(){
        //System.out.println("Laptop Object constructor");
    }
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        //System.out.println("Setter for processor called");
        this.processor = processor;
    }
    public void code(){
        System.out.println("Compiling using Laptop");
    }
    public void playingGame(){
        System.out.println("Playing game on laptop with processor: "+this.processor);
    }
}
