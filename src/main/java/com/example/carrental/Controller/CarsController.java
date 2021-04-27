package com.example.carrental.Controller;

import com.example.carrental.Model.Cars;
import com.example.carrental.Service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/viewOneCar/{carID}")
    public String viewCar(@PathVariable("carID") int carID, Model model){
        model.addAttribute("car", carsService.findCarsById(carID));

        return "cars/viewOne";
    }

    /*
    @GetMapping("/updateOneCar/{carID}")
    public String updateCar(@PathVariable("carID") int carID, Model model){

    }
     */
}
