package com.example.carrental.Controller;

import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Customer;
import com.example.carrental.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    CarsService carsService;

    @GetMapping("/cars")
    public String cars(Model model){
        List<Cars> carList = carsService.fetchAll();
        model.addAttribute("carList", carList);
        return "cars/index";
    }

    @GetMapping("/createCar")
    public String create() {
        return "cars/createCar";
    }

    @PostMapping("/createCar")
    public String createCars(@ModelAttribute Cars car) {
        carsService.addCars(car);
        return "redirect:/cars";
    }

    @GetMapping("/viewOneCar/{carID}")
    public String viewCar(@PathVariable("carID") int carID, Model model){
        model.addAttribute("car", carsService.findCarsById(carID));

        return "cars/viewOne";
    }

    @GetMapping("/updateOneCar/{carID}")
    public String update(@PathVariable("carID") int carID, Model model){
        model.addAttribute("cars", carsService.findCarsById(carID));

        return "cars/updateCar";
    }

    @PostMapping("/updateOneCar")
    public String updateCar(@ModelAttribute Cars cars) {
        carsService.updateCar(cars.getCarID(), cars);
        return "redirect:/cars";
    }

    @GetMapping("/deleteCar/{carID}")
    public String deleteCars(@PathVariable("carID") int carID) {
        boolean deleted = carsService.deleteCars(carID);
        if(deleted) {
            System.out.println("Bil slettet");
        } else {
            System.out.println("Noget gik galt");
        }
        return "redirect:/cars";
    }
}
