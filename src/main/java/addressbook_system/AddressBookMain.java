package addressbook_system;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    static final int ADD_CONTACT = 1;
    static final int EDIT_CONTACT = 2;
    static final int DELETE_CONTACT = 3;
    static final int DISPLAY_ADDRESS_BOOK = 4;
    static final int EXIT = 5;

    public String addressBookName;
    public ArrayList<Contact> contacts = new ArrayList<Contact>();

    AddressBookMain(String addressBookName){
        this.addressBookName = addressBookName;
    }

    static int displayChoices(Scanner scannerObject){
        
        System.out.println("1.] Add contact");
        System.out.println("2.] Edit contact");
        System.out.println("3.] Delete contact");
        System.out.println("4.] Display Address Book");
        System.out.println("5.] Exit");

        System.out.println("Enter your choice: ");
        
        int choice = 0;
        
        choice = scannerObject.nextInt();
        System.out.println();

        return choice;
    }

    static void setContactInformation(Contact newContact, Scanner scannerObject)
    {
            System.out.println("Enter First Name: ");
            newContact.setFirstName(scannerObject.next());
    
            System.out.println("Enter Last Name: ");
            newContact.setLastName(scannerObject.next());
    
            System.out.println("Enter Address: ");
            newContact.setAddress(scannerObject.next());
    
            System.out.println("Enter City: ");
            newContact.setCity(scannerObject.next());
    
            System.out.println("Enter State: ");
            newContact.setState(scannerObject.next());
    
            System.out.println("Enter Zip Code: ");
            newContact.setZipCode(scannerObject.nextInt());
    
            System.out.println("Enter Phone Number: ");
            newContact.setPhoneNumber(scannerObject.nextLong());
    
            System.out.println("Enter Email Id: ");
            newContact.setEmail(scannerObject.next());
    }

    static int getEditChoice(Scanner scannerObject)
    {
            System.out.println("1.] Edit First Name");   
            System.out.println("2.] Edit Last Name");
            System.out.println("3.] Edit Address");
            System.out.println("4.] Edit City");
            System.out.println("5.] Edit State");
            System.out.println("6.] Edit Zip Code");
            System.out.println("7.] Edit Phone Number");
            System.out.println("8.] Edit Email Id");

            System.out.println();
            System.out.println("Enter the field number you wish to edit: ");

            int editChoice = scannerObject.nextInt();
            return editChoice;
    }

    int getIndex(String firstName)
    {
        int contactIndex = -1;
        int addressBookSize = contacts.size();
        
        for(int currIndex = 0; currIndex < addressBookSize; currIndex++)
        {
            if(contacts.get(currIndex).getFirstName().equals(firstName))
            {
                contactIndex = currIndex;
                break;
            }
        }

        return contactIndex;
    }

    void printAddressBook()
    {
        int addressBookSize = contacts.size();

        System.out.println("-------------------------------------------------");
        if(addressBookSize == 0)
        {
            
            System.out.println("Address Book is empty.");
            System.out.println("-------------------------------------------------");
            System.out.println();
            return;
        }

        for(int currIdx = 0; currIdx < addressBookSize; currIdx++)
        {
            System.out.print("Contact Number: " + (currIdx + 1));
            contacts.get(currIdx).displayContact();
            System.out.println();
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        System.out.println();
        return;
    }

    public void performCRUD(Scanner scannerObject){
    
        while(true){
            
            int userChoice = displayChoices(scannerObject);

            switch (userChoice) {
                case ADD_CONTACT:
                    Contact newContact = new Contact();
                    setContactInformation(newContact, scannerObject);
                    contacts.add(newContact);

                    newContact.displayContact();

                    System.out.println("Size of AddressBook is: " + contacts.size());                    
                    System.out.println();
                    break;

                case EDIT_CONTACT:

                    System.out.println("Enter the name of the contact to be edited: ");
                    String editContactName = scannerObject.next();

                    int editIndex = getIndex(editContactName);
                    if(editIndex < 0){
                        System.out.println("Contact Not Found in the Address Book.");
                    }else{
                        int editChoice = getEditChoice(scannerObject);
                        contacts.get(editIndex).editField(editChoice);
                    }
                    break;
                
                case DELETE_CONTACT:
                    System.out.println("Enter the name of the contact to be deleted: ");
                    String deleteContactName = scannerObject.next();

                    int deleteIndex = getIndex(deleteContactName);
                    if(deleteIndex >= 0){
                        contacts.remove(deleteIndex);
                    }
                    break;
                
                case DISPLAY_ADDRESS_BOOK:
                    printAddressBook();
                    break;
                
                case EXIT:
                    return;
            }
        }
    }
}