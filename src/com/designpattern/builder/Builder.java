package com.designpattern.builder;

import java.util.Scanner;

public class Builder {
    public static void main(String[] args) {
        System.out.println("Builder Pattern");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Enter Company - ");
            String company = scanner.nextLine();
            System.out.print("Enter Operating System - ");
            String operatingSystem = scanner.nextLine();
            System.out.print("Enter RAM Size - ");
            String ramSize = scanner.nextLine();
            System.out.print("Enter Hard Disk Size - ");
            String hardDiskSize = scanner.nextLine();
            System.out.print("Enter System Type - ");
            String systemType = scanner.nextLine();

            Computer computer = new Computer.ComputerBuilder(company, operatingSystem)
                    .setRamSize(ramSize)
                    .setHardDiskSize(hardDiskSize)
                    .setSystemType(systemType)
                    .build();
            System.out.println(computer);

            System.out.println("Do you want to build new computer : Y/N - ");
            if(scanner.nextLine().equalsIgnoreCase("Y")) {
                break;
            }
        }
        /*Computer computer = new Computer.ComputerBuilder("Apple", "Mac")
                .setRamSize("4GB")
                .setHardDiskSize("500GB")
                .setSystemType("64Bit")
                .build();
        System.out.println(computer);

        Computer computer2 = new Computer.ComputerBuilder("Dell", "Windows")
                .setRamSize("8GB")
                .setSystemType("64Bit")
                .build();
        System.out.println(computer2);

        Computer computer3 = new Computer.ComputerBuilder("Sony", "Windows")
                .setRamSize("8GB")
                .setHardDiskSize("1000GB")
                .build();
        System.out.println(computer3);*/

    }
}

class Computer {
    String company;
    String operatingSystem;
    String ramSize;
    String hardDiskSize;
    String systemType;

    private Computer(ComputerBuilder computerBuilder) {
        this.company = computerBuilder.company;
        this.operatingSystem = computerBuilder.operatingSystem;
        this.ramSize = computerBuilder.ramSize;
        this.hardDiskSize = computerBuilder.hardDiskSize;
        this.systemType = computerBuilder.systemType;
    }

    static class ComputerBuilder {
        String company;
        String operatingSystem;
        String ramSize;
        String hardDiskSize;
        String systemType;

        ComputerBuilder(String company, String operatingSystem) {
            this.company = company;
            this.operatingSystem = operatingSystem;
        }

        ComputerBuilder setRamSize(String ramSize) {
            this.ramSize = ramSize;
            return this;
        }

        ComputerBuilder setHardDiskSize(String hardDiskSize) {
            this.hardDiskSize = hardDiskSize;
            return this;
        }

        ComputerBuilder setSystemType(String systemType) {
            this.systemType = systemType;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "company='" + company + '\'' +
                ", operating system='" + operatingSystem + '\'' +
                ", ram size='" + ramSize + '\'' +
                ", hard disk size='" + hardDiskSize + '\'' +
                ", system type='" + systemType + '\'' +
                '}';
    }
}
