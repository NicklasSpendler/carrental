package com.example.carrental.Controller;

import com.example.carrental.Model.Customer;
import com.example.carrental.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String index(Model model) {
        List<Customer> customerList = customerService.fetchAll();
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }

    @GetMapping("/viewOneCustomer/{customerID}")
    public String viewOne(@PathVariable("customerID") int customerID, Model model){
        model.addAttribute("customer", customerService.findCustomerById(customerID));
        return "customer/viewOne";
    }

    @GetMapping("/updateOneCustomer/{customerID}")
    public String update(@PathVariable("customerID") int customerID, Model model){
        model.addAttribute("customer", customerService.findCustomerById(customerID));
        return "customer/updateCustomer";
    }




}
