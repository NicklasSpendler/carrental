package com.example.carrental.Controller;

import com.example.carrental.Model.Customer;
import com.example.carrental.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/createCustomer")
    public String create() {
        return "customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createPerson(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers";
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

    @PostMapping("/updateOneCustomer")
    public String updatePerson(@ModelAttribute Customer customer) {
        customerService.updatePerson(customer.getCustomerID(), customer);
        return "redirect:/customers";
    }

    @GetMapping("/deleteCustomer/{customerID}")
    public String deleteCustomer(@PathVariable("customerID") int customerID) {
        boolean deleted = customerService.deleteCustomer(customerID);
        if(deleted) {
            System.out.println("Kunde slettet");
        } else {
            System.out.println("Noget gik galt");
        }
        return "redirect:/customers";
    }





}
