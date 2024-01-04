package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookService {
    Map<String, AddressBook> dictionary;
    private static final int ADD_BOOK = 1;
    private static final int GET_BOOK = 2;
    private static final int EXIT_BOOK = 3;

    public AddressBookService() {
        this.dictionary = new HashMap<>();
    }

    public void startAddressBook() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (true) {
            System.out.println("What you want to do in dictionary");
            System.out.println("Press 1 for ADD book, Press 2 for GET book, Press 3 for Exit Dictionary");
            int choice = sc.nextInt();
            switch (choice) {
                case ADD_BOOK:
                    addAddressBook(sc);
                    break;

                case GET_BOOK:
                    getAddressBook(sc);
                    break;

                case EXIT_BOOK:
                    exit = true;
                    break;

                default:
                    System.out.println("invalid request");
                    break;
            }

            if (exit)
                break;
        }
    }

    private void addAddressBook(Scanner sc) {
        System.out.println("Enter the name of Address Book");
        String name = sc.next();
        if (dictionary.containsKey(name))
            System.out.println("this address book already exists");
        else {
            dictionary.put(name, new AddressBook(name));
            System.out.println("Address Book added");
        }
    }

    private void getAddressBook(Scanner sc) {
        System.out.println("Enter the name of Address Book");
        String book = sc.next();
        if (dictionary.containsKey(book)) {
            addDetails(dictionary.get(book));
        }

        else
            System.out.println("Given Address Book not found");
    }

    public void addDetails(AddressBook addressBook) {
        final int ADD_CONTACT = 1;
        final int VIEW_CONTACT = 2;
        final int EDIT_CONTACT = 3;
        final int DELETE_CONTACT = 4;
        final int EXIT_CONTACT = 5;
        Scanner sc = new Scanner(System.in);

        boolean exit = false;

        while (true) {
            System.out.println("What you want to do in addressbook named " + addressBook.name + " :");
            int choice = sc.nextInt();

            switch (choice) {
                case ADD_CONTACT:
                    addressBook.contacts.add(get_input(sc));
                    break;

                case VIEW_CONTACT:
                    addressBook.displayContact();
                    break;

                case EDIT_CONTACT:
                    System.out.println("Enter the name of person whom details u want to change ");
                    String name = sc.next();
                    addressBook.edit_contact(name, get_input(sc));
                    break;

                case DELETE_CONTACT:
                    System.out.println("Enter the name of person whom details u want to delete");
                    String name1 = sc.next();
                    addressBook.delete_contac(name1);
                    break;

                case EXIT_CONTACT:
                    exit = true;
                    System.out.println("Exit Address Book");
                    break;
                default:
                    System.out.println("Invalid Input , Please Try Again....");
                    break;
            }

            if (exit == true)
                break;
        }
    }

    public static Contact get_input(Scanner sc) {
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
