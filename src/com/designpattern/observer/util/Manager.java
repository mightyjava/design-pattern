package com.designpattern.observer.util;

import java.util.Observable;
import java.util.Observer;

public class Manager implements Observer {

    @Override
    public void update(Observable o, Object message) {
        System.out.println("Notifying Manager");
        System.out.println(message);
    }
}
