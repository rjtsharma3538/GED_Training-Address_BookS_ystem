package com.example;

import java.util.*;

public class Main {

    public static final int ADD_CONTACT = 1;
    public static final int VIEW_CONTACT = 2;
    public static final int EXIT_CONTACT = 3;
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        AddressBook addressBook = new AddressBook();

        while(true)
        {
            System.out.println("What you want to do : ");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_CONTACT:
                    addressBook.contacts.add(get_input(sc));
                    break;

                case VIEW_CONTACT:
                    addressBook.displayContact();

                case EXIT_CONTACT:
                    exit = true;
                    System.out.println("Exit Address Book");
                    break;
                default:
                    System.out.println("Invalid Input , Please Try Again....");
                    break;
            }

            if(exit==true)
                break;
        }

        sc.close();
    }

    public static Contact get_input(Scanner sc){
        System.out.println("enter first_name :");
        String firstName = sc.next();

        System.out.println("ENter last name : ");
        String lastName = sc.next();

        System.out.println("Enter Address");
        String Address = sc.next();

        System.out.println("Enter City");
        String city = sc.next();

        System.out.println("Enter Zip");
        String zip = sc.next();
        
        System.out.println("Enter phone number");
        String phone = sc.next();

        System.out.println("Enter email : ");
        String email = sc.next();

        return new Contact(firstName, lastName, Address, city, city, zip, phone, email);
    }
}
