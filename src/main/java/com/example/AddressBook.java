package com.example;

import java.util.ArrayList;

public class AddressBook {

    String name;
    ArrayList<Contact> contacts;

    public AddressBook(String name)
    {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact)
    {
        for(int i=0;i<contacts.size();i++)
        {
            if(contacts.get(i).firstName.equals(contact.firstName))
            {
                System.out.println("This name already exist");
                return;
            }
        }

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

    public void delete_contac(String name)
    {
        for(int i=0;i<contacts.size();i++)
        {
            Contact contact = contacts.get(i);
            if(contact.firstName.equals(name))
            {
                contacts.remove(i);
                i--;
            }
        }
    }
}
