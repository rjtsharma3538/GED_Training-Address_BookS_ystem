package com.example;

import java.util.ArrayList;

public class AddressBook {

    ArrayList<Contact> contacts;

    public AddressBook()
    {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact)
    {
        this.contacts.add(contact);
    }

    public void displayContact()
    {
        for(Contact contact : contacts)
            System.out.println(contact);
    }

    public void edit_contact(String name, Contact newcontact)
    {
        for(int i=0;i < contacts.size();i++)
        {
            Contact contact = contacts.get(i);
            if(contact.firstName.equals(name))
            {
                contacts.set(i, newcontact);
            }
        }
    }
}
