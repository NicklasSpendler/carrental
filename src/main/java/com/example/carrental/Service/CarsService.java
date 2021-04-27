package com.example.carrental.Service;

import com.example.carrental.Model.Cars;
import com.example.carrental.Repository.CarsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    @Autowired
    CarsRepo carsRepo;

    public List<Cars> fetchAll() {
        //SQL code
        return carsRepo.fetchAll();
    }

    public Cars addCars(Cars c) {
        return carsRepo.addCar(c);
    }

    public Cars findCarsById(int id) {
        return carsRepo.findCarById(id);
    }

    public Boolean deleteCars(int id) {
        return carsRepo.deleteCar(id);
    }

    public Cars updateCar (int id, Cars c) {
        return carsRepo.updateCar(id, c);
    }
}
