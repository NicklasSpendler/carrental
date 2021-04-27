package com.example.carrental.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cars {
    @Id
    private int carID;
    private String carType;
    private String brand;
    private String model;
    private String regNumberPlate;
    private String firstRegYearMonth;
    private double kmDriven;

    public Cars(){

    }

    public Cars(int carID, String carType, String brand, String model, String regNumberPlate, String firstRegYearMonth, double kmDriven) {
        this.carID = carID;
        this.carType = carType;
        this.brand = brand;
        this.model = model;
        this.regNumberPlate = regNumberPlate;
        this.firstRegYearMonth = firstRegYearMonth;
        this.kmDriven = kmDriven;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNumberPlate() {
        return regNumberPlate;
    }

    public void setRegNumberPlate(String regNumberPlate) {
        this.regNumberPlate = regNumberPlate;
    }

    public String getFirstRegYearMonth() {
        return firstRegYearMonth;
    }

    public void setFirstRegYearMonth(String firstRegYearMonth) {
        this.firstRegYearMonth = firstRegYearMonth;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }
}
