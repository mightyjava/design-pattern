package com.designpattern;

import java.util.Scanner;

public class FactoryDesignPattern {
    public static void main(String[] args) {
        System.out.println("Factory Design Pattern");
        System.out.print("Enter Animal : ");
        IAnimalFactory animalFactory = new AnimalFactory();
        animalFactory.getAnimalType(new Scanner(System.in).nextLine()).speak();
    }
}

class AnimalNotFoundException extends RuntimeException {
    AnimalNotFoundException(String message) {
        super(message);
    }
}

interface IAnimalFactory {
    IAnimal getAnimalType(String type);
}

class AnimalFactory implements IAnimalFactory {
    @Override
    public IAnimal getAnimalType(String type) {
        if(type.equals("cat")) {
            return new Cat();
        } else if(type.equals("dog")) {
            return new Dog();
        }
        throw new AnimalNotFoundException("Animal not available.");
    }
}

interface IAnimal {
    void speak();
}

class Dog implements IAnimal {
    @Override
    public void speak() {
        System.out.println("Woof Woof");
    }
}

class Cat implements IAnimal {
    @Override
    public void speak() {
        System.out.println("Meow Meow");
    }
}