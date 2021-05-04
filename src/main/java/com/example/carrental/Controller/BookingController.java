package com.example.carrental.Controller;

import com.example.carrental.Model.Booking;
import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Customer;
import com.example.carrental.Service.BookingService;
import com.example.carrental.Service.CarsService;
import com.example.carrental.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.Path;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    CustomerService customerService;
    @Autowired
    BookingService bookingService;
    @Autowired
    CarsService carsService;



    @GetMapping("/booking")
    public String cars(Model model){
        List<Booking> bookingList = bookingService.fetchAll();
        model.addAttribute("bookingList", bookingList);
        return "booking/index";
    }

    @GetMapping("/deleteBooking/{bookingID}")
    public String deleteCustomer(@PathVariable("bookingID") int bookingID) {
        boolean deleted = bookingService.deleteBooking(bookingID);
        if(deleted) {
            System.out.println("booking slettet");
        } else {
            System.out.println("Noget gik galt");
        }
        return "redirect:/booking";
    }

    @GetMapping("/booking/createBooking")
    public String createBooking(Model model){
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customerList", customerList);
        return "booking/createBooking";
    }

    @GetMapping("/chooseOneCar/{customerID}")
    public String chooseCar(@PathVariable("customerID") int customerID, Model model) {
        List<Cars> carList = carsService.fetchAll();
        model.addAttribute("carList", carList);
        model.addAttribute("customerID", customerID);
        return "booking/chooseCar";
    }

    @GetMapping("/chooseBookingDates/{customerID}/{carID}")
    public String chooseBookingDate(@PathVariable("customerID") int customerID, @PathVariable("carID") int carID, Model model) {
        model.addAttribute("customerID", customerID);
        model.addAttribute("carID", carID);
        return "booking/chooseDates";
    }

    @PostMapping("/createBooking")
    public String createBooking(@ModelAttribute Booking booking) {
        bookingService.addBooking(booking);
        return "redirect:/";
    }

    @GetMapping("/updateBooking/{bookingID}")
    public String updateBooking(@PathVariable("bookingID") int bookingID, Model model) {
        model.addAttribute("booking", bookingService.findBookingById(bookingID));
        return "booking/updateBooking";
    }

    @PostMapping("/updateOneBooking")
    public String updateBooking(@ModelAttribute Booking booking) {
        bookingService.updateBooking(booking.getBookingID(), booking);
        return "redirect:/booking";
    }



}
