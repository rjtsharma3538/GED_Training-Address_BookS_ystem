package com.example;

public class Contact {

    String firstName;
    String lastName;
    String city;
    String address;
    String state;
    String zip;
    String phone;
    String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
            String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
