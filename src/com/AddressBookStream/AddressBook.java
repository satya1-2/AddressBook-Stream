package com.AddressBookStream;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

class Contact {
    String name;
    String lastName;
    String zip;
    String Address;
    String city;
    String phoneNumber;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(String name, String lastName, String zip, String city, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.zip = zip;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {

        return " name " + name + " " + " lastName " + lastName + " " + " Zip " + zip + " " + " city " + city + " " + " phoneNumber " + phoneNumber + " " + "Email " + email + "";
    }
}

public class AddressBook {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("satya", "yadav", "92348", "gorakhpur", "765234567", "ssiu23r@gmail.com"));
        contactList.add(new Contact("kundan ", "kumar", "92334", "shivdhar", "7645567", "kuhgd23@gmail.com"));
        contactList.add(new Contact("praveen", "singh", "92348", "bangaluru", "345234567", "prav12@gmail.com"));
        contactList.add(new Contact("shubham", "kush", "6543", "pune", "234234567", "subh56@gmail.com"));
        contactList.add(new Contact("elam", "prethi", "24548", "maharastra", "985234567", "elam97@gmail.com"));

//   filter the alphabetic name with Strat with s
        System.out.println("serach with alphabet of name : ");
        List<Contact> newS = contactList.stream().filter(e -> e.name.startsWith("s")).collect(Collectors.toList());
        System.out.println(newS);

        // filter the city name who start with S
        System.out.println("searched with alphabet of city : ");
        List<Contact> newSs = contactList.stream().filter(e -> e.city.startsWith("s")).collect(Collectors.toList());
        System.out.println(newSs);

        //  when only one contach detail need then we can use it
        System.out.println("only one contact list needed then : ");
        Contact praveen = contactList.stream()
                .filter(P -> "praveen".equals(P.getName()))
                .findAny()
                .orElse(null);
        System.out.println(praveen);

        System.out.println("printing all contact  in one list : ");
        List<Contact> sortedList = contactList.stream()
                .sorted(Comparator.comparing(contactList::contains))
                .collect(Collectors.toList());
        System.out.println(sortedList);


        // Converting Contact List into a Map search two thing and
        System.out.println("fining two thing from contact list one is city and other is phonenumber : ");
        Map<String, String> productPriceMap =
                contactList.stream()
                        .collect(Collectors.toMap(p -> p.city, p -> p.phoneNumber));

        System.out.println(productPriceMap);


    }
}