package com.designpattern.observer;

public class HR implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Notifying HR");
        System.out.println(message);
    }
}
