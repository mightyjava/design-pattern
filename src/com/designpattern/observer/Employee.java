package com.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Subject {
    private String name;
    private int age;
    private int salary;
    private int oldSalary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update("Salary incremented for "+this.name+" from "+this.oldSalary+" to "+this.salary);
        });
    }

    public void incrementSalary(int percentage) {
        this.oldSalary = this.salary;
        this.salary += this.salary / percentage;
        notifyObservers();
    }
}
