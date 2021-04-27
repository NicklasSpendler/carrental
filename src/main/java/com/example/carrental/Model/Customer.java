package com.example.carrental.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private int customerID;
    private String firstName;
    private String lastName;
    private int zipCode;
    private String cityName;
    private String adress;
    private int mobileNr;
    private String email;
    private int driversLicenceNumber;
    private String customerSinceDate;

    public Customer() {
    }

    public Customer(int customerID, String firstName, String lastName, int zipCode, String cityName, String adress, int mobileNr, String email, int driversLicenceNumber, String customerSinceDate) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.cityName = cityName;
        this.adress = adress;
        this.mobileNr = mobileNr;
        this.email = email;
        this.driversLicenceNumber = driversLicenceNumber;
        this.customerSinceDate = customerSinceDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getMobileNr() {
        return mobileNr;
    }

    public void setMobileNr(int mobileNr) {
        this.mobileNr = mobileNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDriversLicenceNumber() {
        return driversLicenceNumber;
    }

    public void setDriversLicenceNumber(int driversLicenceNumber) {
        this.driversLicenceNumber = driversLicenceNumber;
    }

    public String getCustomerSinceDate() {
        return customerSinceDate;
    }

    public void setCustomerSinceDate(String customerSinceDate) {
        this.customerSinceDate = customerSinceDate;
    }
}
