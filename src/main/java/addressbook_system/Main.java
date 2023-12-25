package addressbook_system;

import java.util.*;

public class Main {

    private static final int CREATE_ADDRESSBOOK = 1;
    private static final int CRUD_OPERATIONS = 2;
    private static final int DISPLAY_ADDRESSBOOK = 3;
    private static final int EXIT = 4;

    static ArrayList<AddressBookMain> addressBookList = new ArrayList<AddressBookMain>();;
    static Map<String, AddressBookMain> nameToAddressBook = new HashMap<>();

    static int displayMenu(Scanner scannerObject){

        System.out.println("1.] Create a new addressbook");
        System.out.println("2.] CRUD operations in Address Book");
        System.out.println("3.] Display list of Address Books");
        System.out.println("4.] Exit");
        System.out.println("Enter a choice: ");
        
        int choice = scannerObject.nextInt();
        System.out.println();

        return choice;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");
        
        Scanner scannerObject = new Scanner(System.in);

        while(true){
            int choice = displayMenu(scannerObject);

            switch (choice) {
                case CREATE_ADDRESSBOOK:
                    
                    System.out.println("Enter the name for new Address Book:");
                    String newAddressBookName = scannerObject.next();

                    if(nameToAddressBook.containsKey(newAddressBookName))
                    {
                        System.out.println("Address Book with this name already exists, try another name.");
                        System.out.println();
                        break;
                    }

                    AddressBookMain newAddressBook = new AddressBookMain(newAddressBookName);
                    addressBookList.add(newAddressBook);
                    nameToAddressBook.put(newAddressBookName, newAddressBook);
                    break;

                case CRUD_OPERATIONS:
                    System.out.println("Enter the name of Address Book you want to perform CRUD operations on: ");
                    String crudAddressBookName = scannerObject.next();

                    if(!nameToAddressBook.containsKey(crudAddressBookName))
                    {
                        System.out.println("Invalid Address Book, cannot perform operations.");
                        break;
                    }

                    nameToAddressBook.get(crudAddressBookName).performCRUD(scannerObject);
                    break;

                case DISPLAY_ADDRESSBOOK:
                    System.out.println("Address Book List --> ");

                    if(addressBookList.size() == 0)
                    {
                        System.out.println("No Address Books.");
                        System.out.println();
                        break;
                    }
                    for(AddressBookMain currAddressBook: addressBookList)
                    {
                        System.out.println(currAddressBook.addressBookName + ": Contains " + currAddressBook.contacts.size() + " contacts.");
                    }
                    System.out.println();
                    break;

                case EXIT:
                    scannerObject.close();
                    return;
            }
        }
    }
}