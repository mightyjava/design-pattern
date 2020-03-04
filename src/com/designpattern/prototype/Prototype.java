package com.designpattern.prototype;

import java.util.Random;

public class Prototype {
    public static void main(String [] args) throws CloneNotSupportedException {
        System.out.println("Prototype Pattern");

        BasicCar bmwCar = new BMW("Black BMW X5");
        bmwCar.price = 200000;

        BasicCar audiCar = new Audi("White Audi Q5");
        audiCar.price = 180000;

        BasicCar bmwCar1 = (BasicCar) bmwCar.clone();
        bmwCar1.price = BasicCar.setPrice() + bmwCar1.price;
        System.out.println("Car model is "+bmwCar1.getModelName()+ " and price is "+bmwCar1.price);

        BasicCar audiCar1 = (BasicCar) audiCar.clone();
        audiCar1.price = BasicCar.setPrice() + audiCar1.price;
        System.out.println("Car model is "+audiCar1.getModelName()+ " and price is "+audiCar1.price);
    }
}

class Audi extends BasicCar {
    public Audi(String modelName) {
        super.modelName = modelName;
    }

    @Override
    protected BasicCar clone() throws CloneNotSupportedException {
        return (Audi) super.clone();
    }
}

class BMW extends BasicCar {
    public BMW(String modelName) {
        super.modelName = modelName;
    }

    @Override
    protected BasicCar clone() throws CloneNotSupportedException {
        return (BMW) super.clone();
    }
}

class BasicCar implements Cloneable {
    public String modelName;
    public int price = 0;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public static int setPrice() {
        return new Random().nextInt(100000);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (BasicCar) super.clone();
    }
}