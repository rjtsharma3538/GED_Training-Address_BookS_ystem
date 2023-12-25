package addressbook_system;

import java.util.Scanner;

class Contact {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zipCode;
    long phoneNumber;
    String email;

    static Scanner scannerObject = new Scanner(System.in);

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void displayContact(){

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("CONTACT INFORMATION: ");
        System.out.println();
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Address: " + this.address);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip Code: " + this.zipCode);
        System.out.println("Phone Number: " + this.phoneNumber);
        System.out.println("Email Id: " + this.email);
        System.out.println("----------------------------------------");
    }

    public void editField(int editChoice){
        switch (editChoice) {
            case 1:
                System.out.println("Enter Updated First Name: ");
                String updatedFirstName = scannerObject.next();
                this.firstName = updatedFirstName;
                break;
            case 2:
                System.out.println("Enter Updated Last Name: ");
                String updatedLastName = scannerObject.next();
                this.lastName = updatedLastName;
                break;
            case 3:
                System.out.println("Enter Updated Address: ");
                String updatedAddress = scannerObject.next();
                this.address = updatedAddress;
                break;
            
            case 4:
                System.out.println("Enter Updated City: ");
                String updatedCity = scannerObject.next();
                this.city = updatedCity;
                break;
        
            case 5:
                System.out.println("Enter Updated State: ");
                String updatedState = scannerObject.next();
                this.state = updatedState;
                break;
            case 6:
                System.out.println("Enter Updated Zip code: ");
                int updatedZip = scannerObject.nextInt();
                this.zipCode = updatedZip;
                break;
            case 7:
                System.out.println("Enter Updated Phone Number: ");
                long updatedPhoneNumber = scannerObject.nextLong();
                this.phoneNumber = updatedPhoneNumber;
                break;
            case 8:
                System.out.println("Enter Updated Email Id: ");
                String updatedEmail = scannerObject.next();
                this.email = updatedEmail;
                break;
            default:
                break;
        }
    }
}
