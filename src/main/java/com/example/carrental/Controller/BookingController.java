package com.example.carrental.Controller;

import com.example.carrental.Model.Booking;
import com.example.carrental.Model.Customer;
import com.example.carrental.Service.BookingService;
import com.example.carrental.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;
    CustomerService customerService;


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


}
