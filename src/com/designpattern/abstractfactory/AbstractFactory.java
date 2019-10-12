package com.designpattern.abstractfactory;

import java.util.Scanner;

public class AbstractFactory {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Design Pattern");
        System.out.print("Enter Animal : ");
        IAbstractFactory<IAnimal> animalFactory = FactoryProvider.getFactory("animal");
        animalFactory.getType(new Scanner(System.in).nextLine()).speak();

        System.out.print("Enter Human : ");
        IAbstractFactory<IHuman> humanFactory = FactoryProvider.getFactory("human");
        humanFactory.getType(new Scanner(System.in).nextLine()).speak();
    }
}

class FactoryProvider {
    static IAbstractFactory getFactory(String factory) {
        if(factory.equals("animal")) {
            return new AnimalFactory();
        } else if(factory.equals("human")) {
            return new HumanFactory();
        }
        throw new FactoryNotFoundException("Factory not available.");
    }
}

class FactoryNotFoundException extends RuntimeException {
    FactoryNotFoundException(String message) {
        super(message);
    }
}

class AnimalNotFoundException extends RuntimeException {
    AnimalNotFoundException(String message) {
        super(message);
    }
}

class HumanNotFoundException extends RuntimeException {
    HumanNotFoundException(String message) {
        super(message);
    }
}

interface IAbstractFactory<T> {
    T getType(String type);
}

class AnimalFactory implements IAbstractFactory<IAnimal> {
    @Override
    public IAnimal getType(String type) {
        if(type.equals("cat")) {
            return new Cat();
        } else if(type.equals("dog")) {
            return new Dog();
        }
        throw new AnimalNotFoundException("Animal not available.");
    }
}

class HumanFactory implements IAbstractFactory<IHuman> {
    @Override
    public IHuman getType(String type) {
        if(type.equals("male")) {
            return new Male();
        } else if(type.equals("female")) {
            return new Female();
        }
        throw new HumanNotFoundException("Human not available.");
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

interface IHuman {
    void speak();
}

class Male implements IHuman {
    @Override
    public void speak() {
        System.out.println("Blah Blah");
    }
}

class Female implements IHuman {
    @Override
    public void speak() {
        System.out.println("Blah Blah Blah Blah Blah Blah");
    }
}
