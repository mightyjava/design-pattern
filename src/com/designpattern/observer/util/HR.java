package com.designpattern.observer.util;

import java.util.Observable;
import java.util.Observer;

public class HR implements Observer {

    @Override
    public void update(Observable o, Object message) {
        System.out.println("Notifying HR");
        System.out.println(message);
    }
}
