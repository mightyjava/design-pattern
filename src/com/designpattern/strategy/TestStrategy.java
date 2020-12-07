package com.designpattern.strategy;

import java.util.Scanner;

public class TestStrategy {
    public static void main(String[] args) {
        System.out.println("Strategy Design Pattern");
        Context context = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Suggested Authentication Options");
            System.out.println("1 - Using Password");
            System.out.println("2 - Using Social");
            System.out.println("3 - Using Token");
            System.out.print("Please Choose - ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    context = new Context(new PasswordBasedAuthentication());
                    break;
                case "2":
                    context = new Context(new SocialAuthentication());
                    break;
                case "3":
                    context = new Context(new TokenBasedAuthentication());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Option - "+option);
            }
            context.executeStrategy();
            System.out.print("Do you want to continue : Y/N - ");
            if(scanner.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
