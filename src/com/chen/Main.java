package com.chen;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void printMenu(){
        System.out.println("Select an option:");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("1) Print all employees:");
        System.out.println("2) Add an employee: ");
        System.out.println("3) Exit the app");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
    public static void main(String[] args) {
        Database database = new Database();
        while(true){

            printMenu();
            int input = scan.nextInt();

            if(input == 1){
                database.printDatabase();
            } else if(input == 2){
                System.out.println("Please enter a name: ");
                scan.nextLine();
                String name = scan.nextLine().trim();

                System.out.printf("Please enter %s's department: \n", name);
                String department = scan.nextLine().trim();

                System.out.printf("Please enter %s's salary: \n", name);
                double salary = scan.nextDouble();

                database.addContact(name, department, salary);
            } else if (input==3){
                break;
            } else{
                System.out.println("Please select either 1, 2 or 3");
            }
            System.out.println("\n");
        }
    }
}
