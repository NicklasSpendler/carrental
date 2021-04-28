package com.example.carrental.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    int bookingID;
    int customerID;
    int carID;


    String firstName;
    String lastName;
    String model;

    public Booking() {

    }

    public Booking(int bookingID, int customerID, int carID, String firstName, String lastName, String model) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.carID = carID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.model = model;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
