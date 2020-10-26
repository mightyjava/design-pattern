package com.designpattern.observer;

public class Manager implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notifying Manager");
        System.out.println(message);
    }
}
