package com.designpattern.observer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Employee extends Observable {
    private String name;
    private int age;
    private int salary;
    private int oldSalary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void incrementSalary(int percentage) {
        this.oldSalary = this.salary;
        this.salary += this.salary / percentage;
        setChanged();
        notifyObservers("Salary incremented for "+this.name+" from "+this.oldSalary+" to "+this.salary);
    }
}
