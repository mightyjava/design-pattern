package com.designpattern.observer;

public class TestObserver {
    public static void main(String[] args) {
        System.out.println("Observer Design Pattern");
        Manager manager = new Manager();
        HR hr = new HR();

        Employee e1 = new Employee("John", 28, 90000);
        e1.addObserver(manager);
        e1.addObserver(hr);
        e1.incrementSalary(10);

        Employee e2 = new Employee("Martin", 35, 130000);
        e2.addObserver(hr);
        e2.addObserver(manager);
        e2.incrementSalary(16);

        e2.removeObserver(manager);
        e2.incrementSalary(5);
    }
}
